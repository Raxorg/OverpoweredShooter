package com.gdxjam38.opshooter.stuff.projectiles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.stuff.player.Player;

import java.util.Objects;

public abstract class Projectile {

    protected final Vector2 velocity = new Vector2(200,21);
    public final Rectangle hitBox;
    private final Player owner;
    private boolean dead = false;

    public Projectile(Player owner,float x, float y) {
        hitBox = new Rectangle(x, y, 22, 22);
        this.owner = Objects.requireNonNull(owner, "owner cannot be null");
    }

    public void draw(ShapeRenderer renderer){
        if (dead) return;
        renderer.rect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
    }

    protected abstract void onTouch(Player player);


    public void update(Array<Player> players, float delta) {
        if (dead) return;
        for (Player player : players) {
            if (player == owner) continue;
            if (hitBox.overlaps(player.hitBox)){
                onTouch(player);
                dead = true;
                return;
            }
        }
        hitBox.x += velocity.x * delta;
        hitBox.y += velocity.y * delta;
    }

}
