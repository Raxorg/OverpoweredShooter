package com.gdxjam38.opshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {

    public static final Skin skin = new Skin(Gdx.files.internal("uiskin/uiskin.json"));
    public static final Texture tile1 = new Texture("tile1.png");
    public static final Texture bush1 = new Texture("bush1.png");
    public static final Texture arrow = new Texture("arrow2.png");
    public static final Texture playerSheet = new Texture("playerSheet.png");

    /**
     * Disposes {@link FirstScreen} related assets
     */
    public static void disposeFirst() {
        skin.dispose();
        tile1.dispose();
        bush1.dispose();
        arrow.dispose();
        playerSheet.dispose();
    }

    /**
     * Disposes {@link SplashScreen} related assets
     */
    public static void disposeSplash() {
        // TODO: 9/16/2026 Dispose splash assets
    }
}