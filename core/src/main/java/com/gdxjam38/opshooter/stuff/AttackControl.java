package com.gdxjam38.opshooter.stuff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AttackControl {

    private final Sprite arrow;
    private float time;

    public AttackControl() {
        Texture arrowTex = new Texture("arrow.png");
        arrow = new Sprite(arrowTex);
        arrow.setSize(100f, 50f);
        arrow.setOriginCenter();
    }

    public void draw(SpriteBatch spriteBatch) {
        arrow.draw(spriteBatch);
    }

    public void setPosition() {

    }

    public void rotate(float degrees) {
        arrow.rotate(degrees);
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
}
