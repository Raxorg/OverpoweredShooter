package com.gdxjam38.opshooter.logic;

import static com.badlogic.gdx.Input.Keys.F;
import static com.badlogic.gdx.Input.Keys.P;
import static com.badlogic.gdx.graphics.Color.BLUE;
import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.RED;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.player.components.AttackControl;

public class AttackHandler {

    private final Player player1, player2;
    private final AttackControl attackControl1, attackControl2;

    public AttackHandler(Stuff stuff) {
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
        float x = player1.hitBox.x + player1.hitBox.width * 0.5f;
        float y = player1.hitBox.y + player1.hitBox.height * 0.5f;
        attackControl1.setPosition(x, y);

        x = player2.hitBox.x + player2.hitBox.width * 0.5f;
        y = player2.hitBox.y + player2.hitBox.height * 0.5f;
        attackControl2.setPosition(x, y);

        attackControl1.rotate(180f * delta);
        attackControl2.rotate(180f * delta);
    }
}
