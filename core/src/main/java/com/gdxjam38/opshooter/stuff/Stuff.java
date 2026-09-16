package com.gdxjam38.opshooter.stuff;

import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.touchables.Wall;

public class Stuff {

    private final Floor floor;
    private final Player player1, player2;
    private final Wall wall;
    private final Array<Player> players;

    public Stuff() {
        floor = new Floor();
        player1 = new Player(true);
        player2 = new Player(false);
        wall = new Wall();
        players = new Array<>();
        players.add(player1);
        players.add(player2);
    }

    public Floor getFloor() {
        return floor;
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
    public Array<Player> getPlayers(){
        return players;
    }
}