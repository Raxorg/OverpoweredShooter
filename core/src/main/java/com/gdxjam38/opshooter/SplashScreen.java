package com.gdxjam38.opshooter;

import static com.badlogic.gdx.graphics.Color.BLACK;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class SplashScreen extends ScreenAdapter {

    private final SpriteBatch spriteBatch;
    private final Sprite splash;
    private float timer;

    public SplashScreen() {
        spriteBatch = new SpriteBatch();
        splash = new Sprite(Assets.splash);
    }

    @Override
    public void show() {
        splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        timer = 0f;
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void update(float delta) {
        timer += delta;
        if (timer >= 5f) {
            ((Game) (Gdx.app.getApplicationListener())).setScreen(new GameScreen());
        }
    }

    private void draw() {
        ScreenUtils.clear(BLACK);

        spriteBatch.begin();
        splash.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void hide() {
        Assets.disposeSplashAssets();
    }
}
