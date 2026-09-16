package com.gdxjam38.opshooter.stuff.projectiles;

import com.gdxjam38.opshooter.stuff.player.Player;

public class Bullet extends Projectile {
    public Bullet(float x, float y) {
        super(x, y);
    }

    @Override
    public void onTouch(Player player) {
        player.health.modifyHp(-20);
    }
}
