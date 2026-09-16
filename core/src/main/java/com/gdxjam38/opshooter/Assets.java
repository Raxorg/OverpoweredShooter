package com.gdxjam38.opshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    public static final Texture ARROW = new Texture(Gdx.files.internal("arrow2.png"));
    public static final Skin SKIN = new Skin(Gdx.files.internal("uiskin/uiskin.json"));

    public static void dispose() {
        ARROW.dispose();
        SKIN.dispose();
    }
}
