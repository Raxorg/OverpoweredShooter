package com.gdxjam38.opshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
    public static final Texture ARROW = new Texture(Gdx.files.internal("arrow2.png"));

    public static void dispose(){
        ARROW.dispose();
    }
}
