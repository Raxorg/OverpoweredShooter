package com.gdxjam38.opshooter.stuff;

import static com.gdxjam38.opshooter.Constants.FLAG_SIZE;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Flag {

    private final Sprite sprite;
    private boolean captured;

    public Flag(Texture flagTex) {
        sprite = new Sprite(flagTex);
        sprite.setSize(FLAG_SIZE, FLAG_SIZE);
        sprite.setOriginCenter();
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    public Vector2 getCenter(Vector2 result) {
        return result.set(sprite.getX() + sprite.getOriginX(), sprite.getY() + sprite.getOriginY());
    }

    public boolean isCaptured() {
        return captured;
    }

    public void setCarried(boolean captured) {
        this.captured = captured;
    }
}