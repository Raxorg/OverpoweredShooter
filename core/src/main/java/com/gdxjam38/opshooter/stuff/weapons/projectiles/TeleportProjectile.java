package com.gdxjam38.opshooter.stuff.weapons.projectiles;

import com.gdxjam38.opshooter.stuff.player.Player;

public class TeleportProjectile extends Projectile{


    public TeleportProjectile(Player owner, float rotation) {
        super(owner, rotation);
    }

    @Override
    protected void onTouch(Player player) {
        owner.hitBox.setPosition(player.hitBox.x, player.hitBox.y);
    }
}
