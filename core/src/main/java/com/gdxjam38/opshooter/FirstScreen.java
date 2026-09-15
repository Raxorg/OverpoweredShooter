package com.gdxjam38.opshooter;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import player.Player;
import touchables.Wall;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class FirstScreen implements Screen {
    private final Player player;
    private final Wall wall;
    ShapeRenderer renderer;

    public FirstScreen() {
        player = new Player();
        wall = new Wall();
    }

    @Override
    public void show() {
        renderer = new ShapeRenderer();
    }

    @Override
    public void render(float delta) {
        player.move(delta);
        wall.wall(player);
        ScreenUtils.clear(0, 0, 0, 1);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        player.draw(renderer);
        wall.draw(renderer);
        renderer.end();

    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if (width <= 0 || height <= 0) return;

        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
