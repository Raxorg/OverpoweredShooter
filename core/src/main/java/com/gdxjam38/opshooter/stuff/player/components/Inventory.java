package com.gdxjam38.opshooter.stuff.player.components;

import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.stuff.weapons.Weapon;

import java.util.Objects;

import static com.gdxjam38.opshooter.Constants.INVENTORY_MAX_CAPACITY;

public class Inventory {

    private final Array<Weapon> inventory = new Array<>();
    private int currentWeapon = 0;

    /**
     * add a weapon to the inventory, 4 weapons max.
     *
     * @param weapon the weapon to add to the inventory
     * @return true if the weapon was successfully added, false otherwise
     * @throws NullPointerException if the weapon passed was null
     */
    public boolean addWeapon(Weapon weapon) {
        if (inventory.size >= INVENTORY_MAX_CAPACITY) return false;
        inventory.add(Objects.requireNonNull(weapon, "weapon cannot be null"));
        return true;
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
