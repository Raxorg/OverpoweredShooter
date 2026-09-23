package com.gdxjam38.opshooter.logic.combat;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.gdxjam38.opshooter.Assets;
import com.gdxjam38.opshooter.stuff.player.Player;

import java.util.Objects;

public class BattleGUI {

    public static final int HEARTS = 3;
    public static final int PAD = 60;

    private final Player[] players;

    private final Stage stage;


    public BattleGUI(Stage stage, Player[] players) {
        this.stage = Objects.requireNonNull(stage, "Stage cannot be null");
        this.players = Objects.requireNonNull(players, "players cannot be null");
    }


    public void update() {

    }

    private void drawHearts(SpriteBatch batch, float position, Player player, boolean reversed) {
        int startX = 0;
        if (reversed) {
            startX = HEARTS * PAD;

            for (float i = player.health.getHpRatio() * HEARTS; i > 0; i--) {
                drawHeartAt(batch, position, startX);
                startX -= PAD;
            }
            return;
        }
        for (int i = 0; i < player.health.getHpRatio() * HEARTS; i++) {
            drawHeartAt(batch, position, startX);
            startX += PAD;
        }
    }

    private void drawHeartAt(SpriteBatch batch, float position, int startX) {
        batch.draw(Assets.heart, startX + position, 30, 40, 40);
    }

    private void drawWeapon(SpriteBatch batch, float position, Player player){
        batch.draw(player.inventory.getCurrentWeapon().texture, position, 30, 60, 40);
    }

    public void draw(SpriteBatch batch) {
        drawHearts(batch, 0, players[0], false);
        drawWeapon(batch, HEARTS * PAD, players[0]);
        drawHearts(batch, 950, players[1], true);
        drawWeapon(batch, 950 , players[1]);
    }
}