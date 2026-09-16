package com.gdxjam38.opshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {

    public static final Skin SKIN = new Skin(Gdx.files.internal("uiskin/uiskin.json"));
    public static final Texture TILE_1 = new Texture(Gdx.files.internal("tile1.png"));
    public static final Texture BUSH_1 = new Texture(Gdx.files.internal("bush1.png"));
    public static final Texture ARROW = new Texture(Gdx.files.internal("arrow2.png"));

    public static void dispose() {
        SKIN.dispose();
        TILE_1.dispose();
        BUSH_1.dispose();
        ARROW.dispose();
    }
}