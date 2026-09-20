package com.gdxjam38.opshooter.stuff;

import static com.gdxjam38.opshooter.Constants.TILE_SIZE;

import com.badlogic.gdx.math.Rectangle;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class RespawnPoint {

    private final Rectangle rectangle;

    public RespawnPoint(float x, float y) {
        rectangle = new Rectangle(x, y, TILE_SIZE, TILE_SIZE);
    }

    public void draw(ShapeDrawer shapeDrawer) {
        shapeDrawer.rectangle(rectangle);
    }
}