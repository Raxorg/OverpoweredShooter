package com.gdxjam38.opshooter;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.touchables.Wall;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class FirstScreen extends ScreenAdapter {
    private final Player player1, player2;

    private final Wall wall;
    private ShapeRenderer renderer;

    public FirstScreen() {
        player1 = new Player(true);
        player2 = new Player(false);
        wall = new Wall();
    }

    @Override
    public void show() {
        renderer = new ShapeRenderer();
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void update(float delta) {
        player1.move(delta);
        player2.move(delta);
        wall.handleCollision(player1);
        wall.handleCollision(player2);
    }

    private void draw() {
        ScreenUtils.clear(0, 0, 0, 1);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        player1.draw(renderer);
        player2.draw(renderer);
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
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}