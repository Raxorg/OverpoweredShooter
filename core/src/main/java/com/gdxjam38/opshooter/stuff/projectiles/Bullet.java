package com.gdxjam38.opshooter.stuff.projectiles;

import com.gdxjam38.opshooter.stuff.player.Player;

public class Bullet extends Projectile {


    public Bullet(Player owner, float rotation, float x, float y) {
        super(owner, rotation, x, y);
    }

    public Bullet(Player owner, float rotation) {
        super(owner, rotation);
    }

    @Override
    public void onTouch(Player player) {
        player.takeDamage(20);
    }
}
