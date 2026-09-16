package com.gdxjam38.opshooter.stuff;

import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.touchables.Wall;

public class Stuff {

    private final Player player1, player2;
    private final Wall wall;

    public Stuff() {
        player1 = new Player(true);
        player2 = new Player(false);
        wall = new Wall();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Wall getWall() {
        return wall;
    }
}