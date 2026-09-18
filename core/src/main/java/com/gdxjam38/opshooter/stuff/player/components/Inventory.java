package com.gdxjam38.opshooter.stuff.player.components;

import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.stuff.weapons.Weapon;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Inventory {

    private final Array<Weapon> inventory = new Array<>();
    private int currentWeapon = 0;

    public void addWeapon(Weapon weapon) {
        inventory.add(Objects.requireNonNull(weapon, "weapon cannot be null"));
    }

    /**
     *
     * @return the current equipped weapon.
     */
    public Weapon getCurrentWeapon() {
        return inventory.get(currentWeapon);
    }

    /**
     *
     * @return the next weapon, null if there's no weapons at all, returns the first weapon if there's no next one.
     */
    @Nullable
    public Weapon moveToNextWeapon() {
        if (inventory.isEmpty()) return null;

        if (currentWeapon != inventory.size - 1) {
            currentWeapon++;
            return inventory.get(currentWeapon);
        }
        currentWeapon = 0;
        return inventory.first();
    }
}
