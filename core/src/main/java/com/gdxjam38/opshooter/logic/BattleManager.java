package com.gdxjam38.opshooter.logic;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.gdxjam38.opshooter.Assets;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;

import java.util.Objects;

public class BattleManager {

    private final Label[] playerHp = new Label[2];
    private final Player[] players = new Player[2];
    private final Stage stage;
    private final DeathHandler deathHandler;

    /**
     * this is to avoid creating a string every frame for no reason
     */
    private final int[] changedHp = new int[2];

    public BattleManager(Stuff stuff, Stage stage) {
        this.stage = Objects.requireNonNull(stage, "Stage cannot be null");

        for (int i = 0; i < stuff.getPlayers().size; i++) {
            players[i] = stuff.getPlayers().get(i);
        }

        generateLabels();
        deathHandler = new DeathHandler(stuff);
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
        deathHandler.update();
    }

    private void updateLabels() {
        for (int i = 0; i < playerHp.length; i++) {
            if (changedHp[i] == players[i].health.getHp()) continue;
            playerHp[i].setText("player" + (i + 1) + " health: " + players[i].health.getHp());
            changedHp[i] = players[i].health.getHp();
        }
    }

    private enum BattleState {
        WON, LOST, WON_BY_TIMEOUT, LOST_BY_TIMEOUT, TIE, GOING
    }

    private BattleState getBattleState() {
        if (MatchTimer.instance.isTimeOver()) {
            if (deathHandler.deathCount[0] > deathHandler.deathCount[1]) {
                return BattleState.LOST_BY_TIMEOUT;
            } else if (deathHandler.deathCount[0] < deathHandler.deathCount[1]) {
                return BattleState.WON_BY_TIMEOUT;
            } else {
                return BattleState.TIE;
            }
        }
        return BattleState.GOING;
    }
}