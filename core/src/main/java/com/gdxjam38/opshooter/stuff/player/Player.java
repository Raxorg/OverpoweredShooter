package com.gdxjam38.opshooter.stuff.player;

import static com.gdxjam38.opshooter.Constants.PLAYER_HEIGHT;
import static com.gdxjam38.opshooter.Constants.PLAYER_WIDTH;
import static com.gdxjam38.opshooter.Constants.PLAYER_STARTING_HEALTH;
import static com.gdxjam38.opshooter.Constants.TILE_SIZE;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam38.opshooter.Direction;
import com.gdxjam38.opshooter.stuff.player.components.AttackControl;
import com.gdxjam38.opshooter.stuff.player.components.Health;
import com.gdxjam38.opshooter.stuff.player.components.Inventory;
import com.gdxjam38.opshooter.stuff.weapons.Gun;

public class Player {

    private final Sprite sprite, upSprite, downSprite, leftSprite, rightSprite;
    public final int upKey, downKey, leftKey, rightKey;
    public final Rectangle hitBox = new Rectangle(0, 0, TILE_SIZE, TILE_SIZE);
    public final Health health;
    public final AttackControl attackControl;
    public final Inventory inventory = new Inventory();

    public Player(Sprite upSprite, Sprite downSprite, Sprite leftSprite, Sprite rightSprite,
                  int upKey, int downKey, int leftKey, int rightKey) {
        this.upSprite = upSprite;
        this.downSprite = downSprite;
        this.leftSprite = leftSprite;
        this.rightSprite = rightSprite;
        sprite = new Sprite(downSprite);
        sprite.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
        sprite.setOriginCenter();
        health = new Health(PLAYER_STARTING_HEALTH);
        attackControl = new AttackControl();
        this.upKey = upKey;
        this.downKey = downKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        inventory.addWeapon(new Gun());
    }

    private float greenness = 1, blueness = 1;

    public void update(float delta) {
        greenness = Math.min(greenness + delta * 4, 1);
        blueness = Math.min(blueness + delta * 4, 1);

        sprite.setColor(1, greenness, blueness, 1);
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
        sprite.setColor(1, greenness, blueness, 1);
        sprite.setPosition(hitBox.x, hitBox.y);
        sprite.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
        sprite.setOriginCenter();
    }

    public void takeDamage(int damage) {
        health.modifyHp(-damage);
        greenness = 0f;
        blueness = 0f;
        sprite.setColor(1f, greenness, blueness, 1f);
    }

    public Vector2 getCenter(Vector2 result) {
        return result.set(sprite.getX() + sprite.getOriginX(), sprite.getY() + sprite.getOriginY());
    }
}