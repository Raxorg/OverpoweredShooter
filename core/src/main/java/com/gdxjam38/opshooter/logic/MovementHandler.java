package com.gdxjam38.opshooter.logic;

import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.touchables.Obstacle;

public class MovementHandler {

    private final Obstacle obstacle;
    private final Array<Player> players;

    public MovementHandler(Stuff stuff) {
        obstacle = stuff.getBush();
        players = stuff.getPlayers();
    }

    public void update(float delta) {
        for (int i = 0; i < players.size; i++) {
            Player player = players.get(i);
            player.move(delta);
            obstacle.handleCollision(player);
        }
    }
}