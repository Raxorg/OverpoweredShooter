package com.gdxjam38.opshooter;

import static com.gdxjam38.opshooter.Constants.CLEAR_COLOR;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.gdxjam38.opshooter.logic.combat.AttackHandler;
import com.gdxjam38.opshooter.logic.combat.BattleManager;
import com.gdxjam38.opshooter.logic.FlagHandler;
import com.gdxjam38.opshooter.logic.MapLoader;
import com.gdxjam38.opshooter.logic.MatchTimer;
import com.gdxjam38.opshooter.logic.MovementHandler;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.weapons.Weapon;

import space.earlygrey.shapedrawer.ShapeDrawer;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class GameScreen extends ScreenAdapter {

    private final SpriteBatch spriteBatch;
    private final ShapeRenderer renderer;
    private final ShapeDrawer shapeDrawer;

    private final Stuff stuff;
    private final MovementHandler movementHandler;
    private final AttackHandler attackHandler;
    private final FlagHandler flagHandler;
    private final Stage stage;
    private final BattleManager battleManager;
    private final MatchTimer timer;
    private final MapLoader mapLoader;

    private static final boolean DEBUG = false;

    public GameScreen() {
        spriteBatch = new SpriteBatch();
        renderer = new ShapeRenderer();
        shapeDrawer = new ShapeDrawer(spriteBatch, new TextureRegion(Assets.pixel));

        stuff = new Stuff();
        movementHandler = new MovementHandler(stuff);
        attackHandler = new AttackHandler(stuff);
        flagHandler = new FlagHandler(stuff);
        stage = new Stage(new FitViewport(1200, 700));
        battleManager = new BattleManager(stuff, stage);
        timer = new MatchTimer(stage);
        mapLoader = new MapLoader(stuff);

        battleManager.setFlagHandler(flagHandler);

        mapLoader.loadMap(Maps.firstMap);
    }

    @Override
    public void show() {
        System.out.println("GameScreen show() called");
        timer.setCounting(true);
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void update(float delta) {
        for (int i = 0; i < Weapon.projectiles.size; i++) {
            Weapon.projectiles.get(i).update(stuff.getObstacles(), stuff.getPlayers(), delta);
        }
        timer.update(delta);
        battleManager.update();
        movementHandler.update(delta);
        attackHandler.update(delta);
        flagHandler.update();
        stage.act(delta);
        for (int i = 0; i < stuff.getPlayers().size; i++) {
            stuff.getPlayers().get(i).update(delta);
        }
    }

    private void draw() {
        ScreenUtils.clear(CLEAR_COLOR);

        spriteBatch.begin();
        stuff.getFloor().draw(spriteBatch);
        stuff.getBlueFlagPlatform().draw(spriteBatch);
        stuff.getRedFlagPlatform().draw(spriteBatch);
        for (int i = 0; i < stuff.getBlueRespawnPoints().size; i++) {
            stuff.getBlueRespawnPoints().get(i).draw(shapeDrawer);
        }
        for (int i = 0; i < stuff.getRedRespawnPoints().size; i++) {
            stuff.getRedRespawnPoints().get(i).draw(shapeDrawer);
        }
        stuff.getRedFlag().draw(spriteBatch);
        stuff.getBlueFlag().draw(spriteBatch);
        for (int i = 0; i < stuff.getPlayers().size; i++) {
            stuff.getPlayers().get(i).attackControl.draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getPlayers().size; i++) {
            stuff.getPlayers().get(i).draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getObstacles().size; i++) {
            stuff.getObstacles().get(i).draw(spriteBatch);
        }
        spriteBatch.end();

        renderer.begin(ShapeRenderer.ShapeType.Line);
        if (DEBUG) {
            for (int i = 0; i < stuff.getPlayers().size; i++) {
                stuff.getPlayers().get(i).drawDebug(renderer);
            }
            for (int i = 0; i < stuff.getObstacles().size; i++) {
                stuff.getObstacles().get(i).drawDebug(renderer);
            }
        }
        for (int i = 0; i < Weapon.projectiles.size; i++) {
            Weapon.projectiles.get(i).draw(renderer);
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
        System.out.println("GameScreen hide() called");
    }

    @Override
    public void dispose() {
        System.out.println("GameScreen dispose() called");
        renderer.dispose();
        spriteBatch.dispose();
        stage.dispose();
        Assets.disposeGameAssets();
    }
}