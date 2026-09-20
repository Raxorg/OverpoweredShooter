package com.gdxjam38.opshooter.stuff.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.weapons.projectiles.Projectile;

import java.util.Objects;

public abstract class Weapon {
    public final Texture texture;

    public Weapon(Texture texture) {
        this.texture = Objects.requireNonNull(texture);
    }

    public static final Array<Projectile> projectiles = new Array<>();

    public abstract void shot(Player owner, float rotation);

    protected void limitLifeTime(Projectile projectile, float lifeTime) {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                destroy(projectile);
            }
        }, lifeTime);
    }

    public static void destroy(Projectile projectile){
        projectiles.removeValue(projectile, false);
    }

}
