package com.gdxjam38.opshooter.logic;

import static com.badlogic.gdx.graphics.Color.BLUE;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.gdxjam38.opshooter.Constants.BUSH_SIZE;
import static com.gdxjam38.opshooter.Constants.TILE_SIZE;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.OrderedMap;
import com.gdxjam38.opshooter.Assets;
import com.gdxjam38.opshooter.stuff.Flag;
import com.gdxjam38.opshooter.stuff.Item;
import com.gdxjam38.opshooter.stuff.RespawnPoint;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.touchables.Obstacle;

public class MapLoader {

    private final Array<RespawnPoint> blueRespawnPoints, redRespawnPoints;
    private final Flag blueFlag, redFlag;
    private final Array<Obstacle> obstacles;

    public MapLoader(Stuff stuff) {
        blueRespawnPoints = stuff.getBlueRespawnPoints();
        redRespawnPoints = stuff.getRedRespawnPoints();
        blueFlag = stuff.getBlueFlag();
        redFlag = stuff.getRedFlag();
        obstacles = stuff.getObstacles();
    }

    public void loadMap(OrderedMap<GridPoint2, Item> map) {
        for (int i = 0; i < map.size; i++) {
            GridPoint2 gridPoint = map.orderedKeys().get(i);
            spawnItem(gridPoint.x, gridPoint.y, map.get(gridPoint));
        }
        redFlag.setPosition(1200f - 2 * TILE_SIZE, 700f - 2 * TILE_SIZE);
        blueFlag.setPosition(TILE_SIZE, TILE_SIZE);
    }

    private void spawnItem(int column, int row, Item item) {
        float x = TILE_SIZE * column;
        float y = TILE_SIZE * row;
        switch (item) {
            case BLUE_SPAWN:
                blueRespawnPoints.add(new RespawnPoint(x, y, BLUE));
                break;
            case RED_SPAWN:
                redRespawnPoints.add(new RespawnPoint(x, y, RED));
                break;
            case BLUE_FLAG:
                blueFlag.setPosition(x, y);
                break;
            case RED_FLAG:
                redFlag.setPosition(x, y);
                break;
            case BUSH:
                Obstacle bush = new Obstacle(Assets.bush1, BUSH_SIZE, BUSH_SIZE);
                bush.setPosition(x, y);
                obstacles.add(bush);
                break;
            case CRATE:
                break;
        }
    }
}