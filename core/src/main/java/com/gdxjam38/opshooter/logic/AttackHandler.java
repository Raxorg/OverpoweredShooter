package com.gdxjam38.opshooter.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.player.components.AttackControl;
import com.gdxjam38.opshooter.stuff.weapons.Weapon;

import static com.badlogic.gdx.Input.Keys.*;
import static com.badlogic.gdx.graphics.Color.*;
import static com.badlogic.gdx.graphics.Color.CLEAR;

public class AttackHandler {

    private final Player player1, player2;
    private final AttackControl attackControl1, attackControl2;
    private final Array<Player> players;

    public AttackHandler(Stuff stuff) {
        players = stuff.getPlayers();
        player1 = stuff.getPlayer1();
        player2 = stuff.getPlayer2();
        attackControl1 = player1.attackControl;
        attackControl2 = player2.attackControl;
    }

    public void update(float delta) {
        updateInput();
        updateControls(delta);
    }

    private void updateInput() {
        handleControl(F, player1, BLUE, attackControl1);
        handleControl(P, player2, RED, attackControl2);
        handleSwitching(TAB, player1, attackControl1);
        handleSwitching(ENTER, player2, attackControl2);
    }

    private void handleSwitching(int key, Player player, AttackControl attackControl){
        if (Gdx.input.isKeyJustPressed(key)){
            Weapon weapon = player.inventory.moveToNextWeapon();
            attackControl.setArrow(weapon.texture);
        }
    }

    private void handleControl(int key, Player player, Color color, AttackControl attackControl) {
        if (Gdx.input.isKeyJustPressed(key)) {
            if (attackControl.isActive()) {
                releaseAttack(attackControl);
                Weapon weapon = player.inventory.getCurrentWeapon();
                weapon.shot(player, attackControl.getRotation());
                attackControl.setArrow(weapon.texture);
            } else showAim(attackControl, color);
        }
    }

    private void releaseAttack(AttackControl attackControl) {
        attackControl.setColor(CLEAR);
        attackControl.setActive(false);
    }

    private void showAim(AttackControl attackControl, Color color) {
        attackControl.setActive(true);
        attackControl.setColor(color);

    }

    private void updateControls(float delta) {
        for (int i = 0; i < players.size; i++) {
            Player player = players.get(i);
            AttackControl attackControl = player.attackControl;
            float x = player.hitBox.x + player.hitBox.width * 0.5f;
            float y = player.hitBox.y + player.hitBox.height * 0.5f;
            attackControl.setPosition(x, y);

            attackControl.rotate(180f * delta);
        }
    }
}