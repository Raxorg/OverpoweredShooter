package com.gdxjam38.opshooter.logic;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;

public class FlagHandler {

    private Vector2 redFlagPos;
    private Array<Player> players;

    public FlagHandler(Stuff stuff) {
        players = stuff.getPlayers();
    }

    public void update(float delta) {
        checkPlayerProximity();
    }

    private void checkPlayerProximity() {

    }

    public void capture() {

    }
}