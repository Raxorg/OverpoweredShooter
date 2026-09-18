package com.gdxjam38.opshooter.stuff.player.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdxjam38.opshooter.Assets;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.gdxjam38.opshooter.Constants.ARROW_HEIGHT;
import static com.gdxjam38.opshooter.Constants.ARROW_WIDTH;

public class AttackControl {

    private final Sprite arrow;
    private boolean active;

    public AttackControl() {
        arrow = new Sprite(Assets.arrow);
        arrow.setSize(ARROW_WIDTH, ARROW_HEIGHT);
        arrow.setColor(CLEAR);
        arrow.setOrigin(0f, arrow.getHeight() * 0.5f);
        arrow.setScale(100, arrow.getScaleY());
    }

    public void draw(SpriteBatch spriteBatch) {
        arrow.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        arrow.setOriginBasedPosition(x, y);
    }

    public void rotate(float degrees) {
        arrow.rotate(degrees);
    }

    public void setColor(Color color) {
        arrow.setColor(color);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     *
     * @return the rotation degree of the arrow from 0 to 360.
     */
    public float getRotation() {
        return arrow.getRotation() % 360;
    }
}