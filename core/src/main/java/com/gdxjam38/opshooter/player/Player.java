package com.gdxjam38.opshooter.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gdxjam38.opshooter.player.components.Health;

public class Player {

    public final Rectangle hitBox = new Rectangle(0, 0, 64, 64);
    public final Health health;
    private final boolean isPlayer1;
    private float speed = 128;

    /**
     * true means this is the first player and will use WASD for his movement, false will use the arrows
     *
     * @param isPlayer1 is this the first player or not
     */
    public Player(boolean isPlayer1) {
        this.isPlayer1 = isPlayer1;
        health = new Health(250);
    }

    public void draw(ShapeRenderer renderer) {
        renderer.rect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
    }

    public void move(float delta) {
        boolean up, down, left, right;
        if (isPlayer1) {
            up = Gdx.input.isKeyPressed(Input.Keys.W);
            down = Gdx.input.isKeyPressed(Input.Keys.S);
            left = Gdx.input.isKeyPressed(Input.Keys.A);
            right = Gdx.input.isKeyPressed(Input.Keys.D);
        } else {
            up = Gdx.input.isKeyPressed(Input.Keys.UP);
            down = Gdx.input.isKeyPressed(Input.Keys.DOWN);
            left = Gdx.input.isKeyPressed(Input.Keys.LEFT);
            right = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        }
        movement(delta, up, down, left, right);
    }

    private void movement(float delta, boolean up, boolean down, boolean left, boolean right) {
        if (left) {
            hitBox.x -= speed * delta;
        }
        if (right) {
            hitBox.x += speed * delta;
        }
        if (up) {
            hitBox.y += speed * delta;
        }
        if (down) {
            hitBox.y -= speed * delta;
        }
    }
}

