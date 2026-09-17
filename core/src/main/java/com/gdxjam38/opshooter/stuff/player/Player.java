package com.gdxjam38.opshooter.stuff.player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Timer;
import com.gdxjam38.opshooter.Direction;
import com.gdxjam38.opshooter.stuff.player.components.AttackControl;
import com.gdxjam38.opshooter.stuff.player.components.Health;

public class Player {

    private final Sprite sprite, upSprite, downSprite, leftSprite, rightSprite;
    public final int upKey, downKey, leftKey, rightKey;
    public final Rectangle hitBox = new Rectangle(0, 0, 64, 64);
    public final Health health;
    public final AttackControl attackControl;

    public Player(Sprite upSprite, Sprite downSprite, Sprite leftSprite, Sprite rightSprite,
                  int upKey, int downKey, int leftKey, int rightKey) {
        this.upSprite = upSprite;
        this.downSprite = downSprite;
        this.leftSprite = leftSprite;
        this.rightSprite = rightSprite;
        sprite = new Sprite(downSprite);
        health = new Health(250);
        attackControl = new AttackControl();
        this.upKey = upKey;
        this.downKey = downKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
    }

    private float greenness, blueness;
    public void update(float delta){
        if (greenness <= 1)
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    greenness = Math.min(greenness + 0.1f, 1);
                    blueness = Math.min(blueness + 0.1f, 1);

                    sprite.setColor(1, greenness, blueness, 1);
                }
            }, delta * 10);
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

    public void setPosition(float x, float y) {
        hitBox.setPosition(x, y);
        sprite.setPosition(x, y);
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

    public void takeDamage(int damage){
        health.modifyHp(-damage);
        greenness = 0f;
        blueness = 0f;
        sprite.setColor(1f, greenness, blueness, 1f);
    }
}