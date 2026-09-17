package com.gdxjam38.opshooter.logic;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.Assets;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;

import java.util.Objects;

public class BattleManager {

    private final Label[] playerHp = new Label[2];
    private final Array<Player> players;
    private final Stage stage;
    /**
     * this is to avoid creating a string every frame for no reason
     */
    private final int[] changedHp = new int[2];

    public BattleManager(Stuff stuff, Stage stage) {
        players = stuff.getPlayers();
        this.stage = Objects.requireNonNull(stage, "Stage cannot be null");
        generateLabels();
    }

    private void generateLabels() {
        Table table = new Table();
        table.bottom();
        table.setFillParent(true);

        playerHp[0] = new Label("", Assets.skin);
        playerHp[1] = new Label("", Assets.skin);

        for (Label playerHp : playerHp) {
            table.add(playerHp).row();
        }
        stage.addActor(table);
    }

    public void update() {
        updateLabels();
    }

    private void updateLabels() {
        for (int i = 0; i < playerHp.length; i++) {
            if (changedHp[i] == players.get(i).health.getHp()) continue;
            playerHp[i].setText("player" + (i + 1) + " health: " + players.get(i).health.getHp());
            changedHp[i] = players.get(i).health.getHp();
        }
    }
}