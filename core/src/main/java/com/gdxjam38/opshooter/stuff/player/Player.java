package com.gdxjam38.opshooter.stuff.player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gdxjam38.opshooter.Assets;
import com.gdxjam38.opshooter.Direction;
import com.gdxjam38.opshooter.stuff.player.components.AttackControl;
import com.gdxjam38.opshooter.stuff.player.components.Health;

public class Player {

    private final Sprite sprite, upSprite, downSprite, leftSprite, rightSprite;
    public final Rectangle hitBox = new Rectangle(0, 0, 64, 64);
    public final Health health;
    public final AttackControl attackControl;
    public final boolean PLAYER_1;
    public final int UP_KEY, DOWN_KEY, LEFT_KEY, RIGHT_KEY;

    /**
     * true means this is the first player, false means player 2
     *
     * @param player1 is this the first player or not
     */
    public Player(boolean player1, int upKey, int downKey, int leftKey, int rightKey) {
        upSprite = new Sprite(Assets.playerSheet, 210, 0, 63, 77);
        downSprite = new Sprite(Assets.playerSheet, 0, 0, 63, 77);
        leftSprite = new Sprite(Assets.playerSheet, 140, 0, 62, 77);
        rightSprite = new Sprite(Assets.playerSheet, 70, 0, 61, 77);
        sprite = new Sprite(downSprite);
        this.PLAYER_1 = player1;
        health = new Health(250);
        attackControl = new AttackControl();
        UP_KEY = upKey;
        DOWN_KEY = downKey;
        LEFT_KEY = leftKey;
        RIGHT_KEY = rightKey;
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public void drawDebug(ShapeRenderer renderer) {
        renderer.rect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
    }

    public void translateX(float amount) {
        hitBox.x += amount;
        sprite.translateX(amount);
    }

    public void translateY(float amount) {
        hitBox.y += amount;
        sprite.translateY(amount);
    }

    public void setDirection(Direction direction) {
        switch (direction) {
            case UP:
                sprite.set(upSprite);
                break;
            case DOWN:
                sprite.set(downSprite);
                break;
            case LEFT:
                sprite.set(leftSprite);
                break;
            case RIGHT:
                sprite.set(rightSprite);
                break;
        }
        sprite.setPosition(hitBox.x, hitBox.y);
    }
}