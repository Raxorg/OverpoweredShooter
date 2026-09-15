package com.gdxjam38.opshooter;

import static com.badlogic.gdx.graphics.Color.GRAY;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gdxjam38.opshooter.logic.AttackHandler;
import com.gdxjam38.opshooter.stuff.Stuff;

public class GroxarScreen extends ScreenAdapter {

    private final SpriteBatch spriteBatch;

    private final Stuff stuff;
    private final AttackHandler attackHandler;

    public GroxarScreen(Stuff stuff) {
        spriteBatch = new SpriteBatch();

        this.stuff = stuff;
        attackHandler = new AttackHandler(stuff);
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void update(float delta) {
        attackHandler.update(delta);
    }

    private void draw() {
        ScreenUtils.clear(GRAY);

        spriteBatch.begin();
        stuff.getAttackControl().draw(spriteBatch);
        spriteBatch.end();
    }
}
