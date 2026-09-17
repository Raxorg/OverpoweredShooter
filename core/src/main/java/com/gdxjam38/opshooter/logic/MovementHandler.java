package com.gdxjam38.opshooter.logic;

import static com.gdxjam38.opshooter.Constants.PLAYER_SPEED;
import static com.gdxjam38.opshooter.Direction.DOWN;
import static com.gdxjam38.opshooter.Direction.LEFT;
import static com.gdxjam38.opshooter.Direction.RIGHT;
import static com.gdxjam38.opshooter.Direction.UP;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.touchables.Obstacle;

public class MovementHandler {

    private final Obstacle bush;
    private final Array<Player> players;

    public MovementHandler(Stuff stuff) {
        bush = stuff.getBush();
        players = stuff.getPlayers();
    }

    public void update(float delta) {
        for (int i = 0; i < players.size; i++) {
            Player player = players.get(i);
            handleInput(player, delta);
            bush.handleCollision(player);
        }
    }

    private void handleInput(Player player, float delta) {
        boolean up, down, left, right;
        up = Gdx.input.isKeyPressed(player.upKey);
        down = Gdx.input.isKeyPressed(player.downKey);
        left = Gdx.input.isKeyPressed(player.leftKey);
        right = Gdx.input.isKeyPressed(player.rightKey);
        movePlayer(player, delta, up, down, left, right);
    }

    private void movePlayer(Player player, float delta, boolean up, boolean down, boolean left, boolean right) {
        float xTranslation = 0f, yTranslation = 0f;
        if (left) {
            xTranslation -= PLAYER_SPEED * delta;
        }
        if (right) {
            xTranslation += PLAYER_SPEED * delta;
        }
        if (up) {
            yTranslation += PLAYER_SPEED * delta;
        }
        if (down) {
            yTranslation -= PLAYER_SPEED * delta;
        }
        player.translateX(xTranslation);
        player.translateY(yTranslation);
        if (xTranslation > 0f) player.setDirection(RIGHT);
        if (xTranslation < 0f) player.setDirection(LEFT);
        if (yTranslation > 0f) player.setDirection(UP);
        if (yTranslation < 0f) player.setDirection(DOWN);
    }
}