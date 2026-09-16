package com.gdxjam38.opshooter.stuff;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.gdxjam38.opshooter.Constants.TILE_SIZE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.gdxjam38.opshooter.Assets;

public class Floor {

    private final Sprite[][] tiles;

    public Floor() {
        tiles = new Sprite[17][10];
        Sprite tile;
        for (int c = 0; c < tiles.length; c++) {
            for (int r = 0; r < tiles[c].length; r++) {
                tiles[c][r] = new Sprite(Assets.TILE_1);
                tile = tiles[c][r];
                tile.setSize(TILE_SIZE, TILE_SIZE);
                tile.setColor(new Color(WHITE).lerp(BLACK, MathUtils.random(0.3f)));
                tile.setPosition(c * TILE_SIZE, r * TILE_SIZE);
            }
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int c = 0; c < tiles.length; c++) {
            for (int r = 0; r < tiles[c].length; r++) {
                tiles[c][r].draw(spriteBatch);
            }
        }
    }
}