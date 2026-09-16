package com.gdxjam38.opshooter.stuff.touchables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gdxjam38.opshooter.stuff.player.Player;

public class Obstacle {

    private final Sprite sprite;
    private final Rectangle hitBox = new Rectangle();

    public Obstacle(Texture texture, float width, float height) {
        sprite = new Sprite(texture);
        sprite.setSize(width, height);
        hitBox.setSize(width, height);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public void drawDebug(ShapeRenderer renderer) {
        renderer.rect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
    }

    public void handleCollision(Player player) {
        if (!hitBox.overlaps(player.hitBox))
            return;
        Rectangle e = player.hitBox;

        float overlapLeft = (e.x + e.width) - hitBox.x;
        float overlapRight = (hitBox.x + hitBox.width) - e.x;
        float overlapBottom = (e.y + e.height) - hitBox.y;
        float overlapTop = (hitBox.y + hitBox.height) - e.y;

        float minOverlapX = Math.min(overlapLeft, overlapRight);
        float minOverlapY = Math.min(overlapBottom, overlapTop);

        if (minOverlapX < minOverlapY) {
            e.x += (overlapLeft < overlapRight) ? -minOverlapX : minOverlapX;
            return;
        }
        e.y += (overlapBottom < overlapTop) ? -minOverlapY : minOverlapY;
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
        hitBox.setPosition(x, y);
    }
}