package com.gdxjam38.opshooter;

import static com.badlogic.gdx.graphics.Color.BLACK;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gdxjam38.opshooter.logic.AttackHandler;
import com.gdxjam38.opshooter.logic.MovementHandler;
import com.gdxjam38.opshooter.stuff.Stuff;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class FirstScreen extends ScreenAdapter {

    private final SpriteBatch spriteBatch;
    private final ShapeRenderer renderer;
    private final Stuff stuff;
    private final MovementHandler movementHandler;
    private final AttackHandler attackHandler;

    public FirstScreen() {
        spriteBatch = new SpriteBatch();
        renderer = new ShapeRenderer();
        stuff = new Stuff();
        movementHandler = new MovementHandler(stuff);
        attackHandler = new AttackHandler(stuff);
    }

    @Override
    public void show() {
        System.out.println("FirstScreen show() called");
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void update(float delta) {
        movementHandler.update(delta);
        attackHandler.update(delta);
    }

    private void draw() {
        ScreenUtils.clear(BLACK);

        spriteBatch.begin();
        stuff.getPlayer1().attackControl.draw(spriteBatch);
        stuff.getPlayer2().attackControl.draw(spriteBatch);
        spriteBatch.end();

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        stuff.getPlayer1().draw(renderer);
        stuff.getPlayer2().draw(renderer);
        stuff.getWall().draw(renderer);
        renderer.end();
    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if (width <= 0 || height <= 0) System.out.println("width and height are 0");

        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
        System.out.println("FirstScreen hide() called");
    }

    @Override
    public void dispose() {
        System.out.println("FirstScreen dispose() called");
        renderer.dispose();
    }
}