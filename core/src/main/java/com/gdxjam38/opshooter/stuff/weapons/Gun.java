package com.gdxjam38.opshooter.stuff.weapons;

import com.badlogic.gdx.utils.Timer;
import static com.gdxjam38.opshooter.Constants.*;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.weapons.projectiles.Bullet;
import com.gdxjam38.opshooter.stuff.weapons.projectiles.Projectile;

public class Gun extends Weapon {


    @Override
    public void shot(Player owner, float rotation) {
        Projectile bullet = new Bullet(owner, rotation);
        projectiles.add(bullet);
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                projectiles.removeValue(bullet, false);
            }
        }, BULLETS_LIFE_SPAN);

    }
}
