package com.gdxjam38.opshooter.logic;

import static com.badlogic.gdx.Input.Keys.F;
import static com.badlogic.gdx.Input.Keys.P;
import static com.badlogic.gdx.graphics.Color.BLUE;
import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.RED;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.player.components.AttackControl;

public class AttackHandler {

    private final AttackControl attackControl1, attackControl2;
    private final Array<Player> players;

    public AttackHandler(Stuff stuff) {
        players = stuff.getPlayers();
        attackControl1 = stuff.getPlayer1().attackControl;
        attackControl2 = stuff.getPlayer2().attackControl;
    }

    public void update(float delta) {
        updateInput();
        updateControls(delta);
    }

    private void updateInput() {
        if (Gdx.input.isKeyJustPressed(F)) {
            if (attackControl1.isActive()) releaseAttack(attackControl1);
            else showAim(attackControl1, RED);
        }
        if (Gdx.input.isKeyJustPressed(P)) {
            if (attackControl2.isActive()) releaseAttack(attackControl2);
            else showAim(attackControl2, BLUE);
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
        for (Player player : players){
            AttackControl attackControl = player.attackControl;
            float x = player.hitBox.x + player.hitBox.width * 0.5f;
            float y = player.hitBox.y + player.hitBox.height * 0.5f;
            attackControl.setPosition(x, y);

            attackControl.rotate(180f * delta);
        }
    }
}
