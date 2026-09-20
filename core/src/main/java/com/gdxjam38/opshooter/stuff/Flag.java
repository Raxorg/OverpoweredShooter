package com.gdxjam38.opshooter.stuff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Flag {

    private final Sprite sprite;

    public Flag(Texture flagTex) {
        sprite = new Sprite(flagTex);
        sprite.setSize(75f, 75f);
        sprite.setOriginCenter();
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    public Vector2 getCenter(Vector2 result) {
        return result.set(sprite.getOriginX(), sprite.getOriginY());
    }
}