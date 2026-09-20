package com.gdxjam38.opshooter.stuff;

import static com.gdxjam38.opshooter.Constants.TILE_SIZE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class RespawnPoint {

    private final Rectangle rectangle;
    private final Color color;

    public RespawnPoint(float x, float y, Color color) {
        rectangle = new Rectangle(x, y, TILE_SIZE, TILE_SIZE);
        this.color = new Color(color);
    }

    public void draw(ShapeDrawer shapeDrawer) {
        shapeDrawer.rectangle(rectangle, color);
    }
}