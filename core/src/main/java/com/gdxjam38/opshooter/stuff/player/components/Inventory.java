package com.gdxjam38.opshooter.stuff.player.components;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;
import com.gdxjam38.opshooter.stuff.weapons.Weapon;
import org.jetbrains.annotations.Nullable;

public class Inventory {

    private final Array<Weapon> inventory = new Array<>();
    private int currentWeapon = 0;

    public void addWeapon(Weapon weapon) {
        inventory.add(weapon);
    }

    /**
     *
     * @return the current equipped weapon, null if there's no weapons
     */
    public Weapon getCurrentWeapon() {
        return inventory.get(currentWeapon);
    }

    /**
     *
     * @return the next weapon, null if there's no next weapon, or there's no weapons at all
     */
    @Nullable
    public Weapon moveToNextWeapon() {
        if (inventory.isEmpty()) return null;

        if (inventory.size >= currentWeapon) {
            currentWeapon++;
            return inventory.get(currentWeapon);
        }
        return null;
    }
}
