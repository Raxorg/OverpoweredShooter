package com.gdxjam38.opshooter.logic;

import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.touchables.Wall;

public class MovementHandler {

    private final Wall wall;
    private final Array<Player> players;

    public MovementHandler(Stuff stuff) {
        wall = stuff.getWall();
        players = stuff.getPlayers();
    }

    public void update(float delta) {
        for (Player player : players) {
            player.move(delta);
            wall.handleCollision(player);
        }
    }
}