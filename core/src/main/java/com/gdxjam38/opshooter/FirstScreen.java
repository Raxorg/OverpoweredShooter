package com.gdxjam38.opshooter;

import static com.gdxjam38.opshooter.Constants.CLEAR_COLOR;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.gdxjam38.opshooter.logic.AttackHandler;
import com.gdxjam38.opshooter.logic.BattleManager;
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
    private final Stage stage;
    private final BattleManager battleManager;

    public FirstScreen() {
        spriteBatch = new SpriteBatch();
        renderer = new ShapeRenderer();
        stuff = new Stuff();
        movementHandler = new MovementHandler(stuff);
        attackHandler = new AttackHandler(stuff);
        stage = new Stage(new FitViewport(1200, 700));
        battleManager = new BattleManager(stuff, stage);
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
        for (int i = 0; i < stuff.getProjectiles().size; i++) {
            stuff.getProjectiles().get(i).update(stuff.getPlayers(), delta);
        }
        battleManager.update();
        movementHandler.update(delta);
        attackHandler.update(delta);
        stage.act(delta);
    }

    private void draw() {
        ScreenUtils.clear(CLEAR_COLOR);

        spriteBatch.begin();
        stuff.getFloor().draw(spriteBatch);
        for (int i = 0; i < stuff.getPlayers().size; i++) {
            stuff.getPlayers().get(i).attackControl.draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getPlayers().size; i++) {
            stuff.getPlayers().get(i).draw(spriteBatch);
        }
        stuff.getBush().draw(spriteBatch);
        spriteBatch.end();

        renderer.begin(ShapeRenderer.ShapeType.Line);
        for (int i = 0; i < stuff.getPlayers().size; i++) {
            stuff.getPlayers().get(i).drawDebug(renderer);
        }
        stuff.getBush().drawDebug(renderer);
        for (int i = 0; i < stuff.getProjectiles().size; i++) {
            stuff.getProjectiles().get(i).draw(renderer);
        }

        renderer.end();

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        if (width <= 0 || height <= 0) return;
        stage.getViewport().update(width, height);
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
        spriteBatch.dispose();
        stage.dispose();
        Assets.disposeFirst();
    }
}