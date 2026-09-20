package com.gdxjam38.opshooter.stuff;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.UP;
import static com.badlogic.gdx.Input.Keys.W;
import static com.gdxjam38.opshooter.Constants.PLAYER_HEIGHT;
import static com.gdxjam38.opshooter.Constants.PLAYER_WIDTH;
import static com.gdxjam38.opshooter.Constants.TILE_SIZE;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.Assets;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.touchables.Obstacle;

public class Stuff {

    private final Floor floor;
    private final Player player1, player2;
    private final Obstacle bush;
    private final Flag redFlag, blueFlag;
    private final Array<Player> players;
    private final Array<RespawnPoint> blueRespawnPoints, redRespawnPoints;

    public Stuff() {
        floor = new Floor();

        Sprite upSprite1 = new Sprite(Assets.playerSheet, 210, 0, 63, 77);
        Sprite downSprite1 = new Sprite(Assets.playerSheet, 0, 0, 63, 77);
        Sprite leftSprite1 = new Sprite(Assets.playerSheet, 140, 0, 62, 77);
        Sprite rightSprite1 = new Sprite(Assets.playerSheet, 70, 0, 61, 77);
        player1 = new Player(upSprite1, downSprite1, leftSprite1, rightSprite1, W, S, A, D);
        player1.setPosition(0f, 0f);

        Sprite upSprite2 = new Sprite(Assets.playerSheet, 210, 77, 63, 77);
        Sprite downSprite2 = new Sprite(Assets.playerSheet, 0, 77, 63, 77);
        Sprite leftSprite2 = new Sprite(Assets.playerSheet, 140, 77, 62, 77);
        Sprite rightSprite2 = new Sprite(Assets.playerSheet, 70, 77, 61, 77);
        player2 = new Player(upSprite2, downSprite2, leftSprite2, rightSprite2, UP, DOWN, LEFT, RIGHT);
        player2.setPosition(1200f - PLAYER_WIDTH, 700f - PLAYER_HEIGHT);

        bush = new Obstacle(Assets.bush1, 75f, 75f);
        bush.setPosition(200f, 100f);

        redFlag = new Flag(Assets.redFlag);
        redFlag.setPosition(1200f - 2 * TILE_SIZE, 700f - 2 * TILE_SIZE);
        blueFlag = new Flag(Assets.blueFlag);
        blueFlag.setPosition(TILE_SIZE, TILE_SIZE);

        players = new Array<>();
        players.add(player1);
        players.add(player2);

        blueRespawnPoints = new Array<>();
        blueRespawnPoints.add(new RespawnPoint(300, 350));
        blueRespawnPoints.add(new RespawnPoint(50, 50));
        blueRespawnPoints.add(new RespawnPoint(50, 650));
        blueRespawnPoints.add(new RespawnPoint(550, 50));
        blueRespawnPoints.add(new RespawnPoint(550, 650));

        redRespawnPoints = new Array<>();
        redRespawnPoints.add(new RespawnPoint(900, 350));
        redRespawnPoints.add(new RespawnPoint(650, 50));
        redRespawnPoints.add(new RespawnPoint(650, 650));
        redRespawnPoints.add(new RespawnPoint(1150, 50));
        redRespawnPoints.add(new RespawnPoint(1150, 650));
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

    public Flag getRedFlag() {
        return redFlag;
    }

    public Flag getBlueFlag() {
        return blueFlag;
    }

    public Array<Player> getPlayers() {
        return players;
    }

    public Array<RespawnPoint> getBlueRespawnPoints() {
        return blueRespawnPoints;
    }

    public Array<RespawnPoint> getRedRespawnPoints() {
        return redRespawnPoints;
    }
}