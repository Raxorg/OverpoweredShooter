package com.gdxjam38.opshooter.logic;

import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.touchables.Wall;

public class MovementHandler {

    private final Player player1, player2;
    private final Wall wall;

    public MovementHandler(Stuff stuff) {
        player1 = stuff.getPlayer1();
        player2 = stuff.getPlayer2();
        wall = stuff.getWall();
    }

    public void update(float delta) {
        player1.move(delta);
        player2.move(delta);
        wall.handleCollision(player1);
        wall.handleCollision(player2);
    }
}