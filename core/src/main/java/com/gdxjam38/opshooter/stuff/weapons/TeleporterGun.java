package com.gdxjam38.opshooter.stuff.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.weapons.projectiles.Projectile;
import com.gdxjam38.opshooter.stuff.weapons.projectiles.TeleportProjectile;

public class TeleporterGun extends Weapon{

    public TeleporterGun(Texture texture) {
        super(texture);
    }

    @Override
    public void shot(Player owner, float rotation) {
        Projectile teleporterProjectile = new TeleportProjectile(owner, rotation);
        projectiles.add(teleporterProjectile);
        limitLifeTime(teleporterProjectile, 10);
    }
}
