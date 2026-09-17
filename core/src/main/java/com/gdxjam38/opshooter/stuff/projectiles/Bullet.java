package com.gdxjam38.opshooter.stuff.projectiles;

import com.gdxjam38.opshooter.stuff.player.Player;

public class Bullet extends Projectile {
    public Bullet(Player owner, float x, float y) {
        super(owner, x, y);
    }

    @Override
    public void onTouch(Player player) {
        player.health.modifyHp(-20);
    }
}
