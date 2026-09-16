package com.gdxjam38.opshooter.stuff;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.UP;
import static com.badlogic.gdx.Input.Keys.W;

import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.Assets;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.projectiles.Projectile;
import com.gdxjam38.opshooter.stuff.touchables.Obstacle;

public class Stuff {

    private final Floor floor;
    private final Player player1, player2;
    private final Obstacle bush;
    private final Array<Player> players;
    private final Array<Projectile> projectiles;

    public Stuff() {
        floor = new Floor();
        player1 = new Player(true, W, S, A, D);
        player2 = new Player(false, UP, DOWN, LEFT, RIGHT);
        bush = new Obstacle(Assets.bush1, 75f, 75f);
        bush.setPosition(200f, 100f);
        players = new Array<>();
        players.add(player1);
        players.add(player2);

        projectiles = new Array<>();
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

    public Obstacle getBush() {
        return bush;
    }

    public Array<Player> getPlayers() {
        return players;
    }

    public Array<Projectile> getProjectiles() {
        return projectiles;
    }
}