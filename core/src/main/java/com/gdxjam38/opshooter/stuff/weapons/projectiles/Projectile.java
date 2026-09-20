package com.gdxjam38.opshooter.stuff.weapons.projectiles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.stuff.player.Player;

import java.util.Objects;


public abstract class Projectile {

    protected final Vector2 velocity = new Vector2();
    protected final Vector2 position = new Vector2();
    protected final Player owner;
    public final Rectangle hitBox;
    private boolean dead = false;
    protected float speed = 1024;

    public Projectile(Player owner, float rotation) {
        this.owner = Objects.requireNonNull(owner, "owner cannot be null");
        owner.hitBox.getCenter(position);
        hitBox = new Rectangle(position.x, position.y, 22, 22);

        rotation = (float) Math.toRadians(rotation);
        float veloX = (float) Math.cos(rotation);
        float veloY = (float) Math.sin(rotation);
        velocity.set(veloX, veloY);
    }

    public void draw(ShapeRenderer renderer) {
        if (dead) return;
        renderer.rect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
    }

    protected abstract void onTouch(Player player);


    public void update(Array<Player> players, float delta) {
        if (dead) return;
        for (Player player : players) {
            if (player == owner) continue;
            if (hitBox.overlaps(player.hitBox)) {
                onTouch(player);
                dead = true;
                return;
            }
        }
        hitBox.x += velocity.x * speed * delta;
        hitBox.y += velocity.y * speed * delta;
    }

}
