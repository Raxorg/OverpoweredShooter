package com.gdxjam38.opshooter.logic.combat;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.gdxjam38.opshooter.logic.FlagHandler;
import com.gdxjam38.opshooter.logic.MatchTimer;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;


public class BattleManager {
    private final Player[] players = new Player[2];
    private final DeathHandler deathHandler;
    public final BattleGUI battleGUI;

    public BattleManager(Stuff stuff, Stage stage) {
        for (int i = 0; i < stuff.getPlayers().size; i++) {
            players[i] = stuff.getPlayers().get(i);
        }

        battleGUI = new BattleGUI(stage, players);
        deathHandler = new DeathHandler(stuff);
    }


    public void update() {
        battleGUI.update();
        deathHandler.update();
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

    public void setFlagHandler(FlagHandler flagHandler) {
        deathHandler.setFlagHandler(flagHandler);
    }
}