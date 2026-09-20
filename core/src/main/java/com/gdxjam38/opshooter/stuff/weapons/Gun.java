package com.gdxjam38.opshooter.stuff.weapons;

import static com.gdxjam38.opshooter.Constants.*;

import com.badlogic.gdx.utils.Timer;
import com.gdxjam38.opshooter.Assets;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.weapons.projectiles.Bullet;
import com.gdxjam38.opshooter.stuff.weapons.projectiles.Projectile;

public class Gun extends Weapon {

    public Gun(){
        super(Assets.gun);
    }

    @Override
    public void shot(Player owner, float rotation) {
        Assets.gunShot.play();
        shootBullet(owner, rotation);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                shootBullet(owner, rotation);
            }
        }, 0.25f);

    }

    private void shootBullet(Player owner, float rotation) {
        Projectile bullet1 = new Bullet(owner, rotation);
        projectiles.add(bullet1);
        limitLifeTime(bullet1, BULLETS_LIFE_SPAN);
    }
}
