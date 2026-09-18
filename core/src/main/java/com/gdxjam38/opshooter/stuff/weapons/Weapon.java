package com.gdxjam38.opshooter.stuff.weapons;

import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.stuff.player.Player;
import com.gdxjam38.opshooter.stuff.weapons.projectiles.Projectile;

public abstract class Weapon {
    public static final Array<Projectile> projectiles = new Array<>();

    public abstract void shot(Player owner, float rotation);

}
