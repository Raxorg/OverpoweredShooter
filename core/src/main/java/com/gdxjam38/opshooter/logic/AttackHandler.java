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
import com.gdxjam38.opshooter.stuff.projectiles.Bullet;
import com.gdxjam38.opshooter.stuff.projectiles.Projectile;

public class AttackHandler {

    private final Player player1, player2;
    private final AttackControl attackControl1, attackControl2;
    private final Array<Player> players;
    private final Array<Projectile> projectiles;

    public AttackHandler(Stuff stuff) {
        players = stuff.getPlayers();
        player1 = stuff.getPlayer1();
        player2 = stuff.getPlayer2();
        attackControl1 = player1.attackControl;
        attackControl2 = player2.attackControl;
        projectiles = stuff.getProjectiles();
    }

    public void update(float delta) {
        updateInput();
        updateControls(delta);
    }

    private void updateInput() {
        if (Gdx.input.isKeyJustPressed(F)) {
            if (attackControl1.isActive()) {
                releaseAttack(attackControl1);
                projectiles.add(new Bullet(player1.hitBox.x + 20, player1.hitBox.y));
            } else showAim(attackControl1, BLUE);
        }
        if (Gdx.input.isKeyJustPressed(P)) {
            if (attackControl2.isActive()) {
                releaseAttack(attackControl2);
                projectiles.add(new Bullet(player2.hitBox.x + 70, player2.hitBox.y));
            } else showAim(attackControl2, RED);
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