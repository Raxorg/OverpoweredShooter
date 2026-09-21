package com.gdxjam38.opshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

@SuppressWarnings("GDXJavaStaticResource")
public class Assets {

    public static final Skin skin = new Skin(Gdx.files.internal("uiskin/uiskin.json"));

    public static final Texture tile1 = new Texture(Gdx.files.internal("tile1.png"));
    public static final Texture bush1 = new Texture(Gdx.files.internal("bush1.png"));
    public static final Texture crate = new Texture(Gdx.files.internal("crate.png"));
    public static final Texture arrow = new Texture(Gdx.files.internal("arrow2.png"));
    public static final Texture playerSheet = new Texture(Gdx.files.internal("playerSheet.png"));
    public static final Texture gun = new Texture(Gdx.files.internal("gun1.png"));
    public static final Texture redFlag = new Texture(Gdx.files.internal("redFlag.png"));
    public static final Texture blueFlag = new Texture(Gdx.files.internal("blueFlag.png"));
    public static final Texture pixel = new Texture(Gdx.files.internal("pixel.png"));
    public static final Texture bullet = new Texture(Gdx.files.internal("bullet.png"));
    public static final Texture bluePlatform = new Texture(Gdx.files.internal("bluePlatform.png"));
    public static final Texture redPlatform = new Texture(Gdx.files.internal("redPlatform.png"));
    public static final Texture splash = new Texture(Gdx.files.internal("splash.png"));

    public static final Sound gunShot = Gdx.audio.newSound(Gdx.files.internal("audio/gun_shoot_1.wav"));

    /**
     * Disposes {@link GameScreen} related assets
     */
    public static void disposeGameAssets() {
        skin.dispose();
        tile1.dispose();
        bush1.dispose();
        crate.dispose();
        arrow.dispose();
        playerSheet.dispose();
        gun.dispose();
        redFlag.dispose();
        blueFlag.dispose();
        pixel.dispose();
        bullet.dispose();
        bluePlatform.dispose();
        redPlatform.dispose();
        gunShot.dispose();
    }

    /**
     * Disposes {@link SplashScreen} related assets
     */
    public static void disposeSplashAssets() {
        splash.dispose();
    }
}