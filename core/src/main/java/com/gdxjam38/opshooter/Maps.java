package com.gdxjam38.opshooter;

import static com.gdxjam38.opshooter.stuff.Item.BLUE_FLAG;
import static com.gdxjam38.opshooter.stuff.Item.BLUE_SPAWN;
import static com.gdxjam38.opshooter.stuff.Item.BUSH;
import static com.gdxjam38.opshooter.stuff.Item.CRATE;
import static com.gdxjam38.opshooter.stuff.Item.RED_FLAG;
import static com.gdxjam38.opshooter.stuff.Item.RED_SPAWN;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.utils.OrderedMap;
import com.gdxjam38.opshooter.stuff.Item;

public class Maps {

    public static final OrderedMap<GridPoint2, Item> firstMap;

    static {
        firstMap = new OrderedMap<>();
        put(0, 2, BLUE_SPAWN);
        put(0, 11, BLUE_SPAWN);
        put(4, 13, BLUE_SPAWN);
        put(4, 9, BLUE_SPAWN);
        put(4, 4, BLUE_SPAWN);
        put(4, 0, BLUE_SPAWN);

        put(23, 2, RED_SPAWN);
        put(23, 11, RED_SPAWN);
        put(19, 13, RED_SPAWN);
        put(19, 9, RED_SPAWN);
        put(19, 4, RED_SPAWN);
        put(19, 0, RED_SPAWN);

        put(1, 1, BLUE_FLAG);
        put(22, 22, RED_FLAG);

        // Blue side bushes
        put(5, 0, BUSH);
        put(5, 1, BUSH);
        // Red side bushes
        put(18, 13, BUSH);
        put(18, 12, BUSH);
        // Crates
        put(0, 7, CRATE);
        put(1, 7, CRATE);
        put(2, 7, CRATE);
        put(3, 7, CRATE);
        put(4, 7, CRATE);

        put(23, 6, CRATE);
        put(22, 6, CRATE);
        put(21, 6, CRATE);
        put(20, 6, CRATE);
        put(19, 6, CRATE);

        put(11, 2, CRATE);
        put(13, 4, CRATE);
        put(11, 5, CRATE);
        put(12, 8, CRATE);
        put(13, 9, CRATE);
        put(12, 10, CRATE);
    }

    private static void put(int column, int row, Item item) {
        firstMap.put(new GridPoint2(column, row), item);
    }
}