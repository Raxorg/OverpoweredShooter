package com.gdxjam38.opshooter.logic;

import static com.badlogic.gdx.graphics.Color.BLUE;
import static com.badlogic.gdx.graphics.Color.RED;
import static com.gdxjam38.opshooter.Constants.OBSTACLE_SIZE;
import static com.gdxjam38.opshooter.Constants.TILE_SIZE;

import com.badlogic.gdx.graphics.g2d.Sprite;
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
    private final Sprite blueFlagPlatform, redFlagPlatform;

    public MapLoader(Stuff stuff) {
        blueRespawnPoints = stuff.getBlueRespawnPoints();
        redRespawnPoints = stuff.getRedRespawnPoints();
        blueFlag = stuff.getBlueFlag();
        redFlag = stuff.getRedFlag();
        obstacles = stuff.getObstacles();
        blueFlagPlatform = stuff.getBlueFlagPlatform();
        redFlagPlatform = stuff.getRedFlagPlatform();
    }

    public void loadMap(OrderedMap<GridPoint2, Item> map) {
        for (int i = 0; i < map.size; i++) {
            GridPoint2 gridPoint = map.orderedKeys().get(i);
            spawnItem(gridPoint.x, gridPoint.y, map.get(gridPoint));
        }
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
                blueFlagPlatform.setPosition(x, y);
                break;
            case RED_FLAG:
                redFlag.setPosition(x, y);
                redFlagPlatform.setPosition(x, y);
                break;
            case BUSH:
                Obstacle bush = new Obstacle(Assets.bush1, OBSTACLE_SIZE, OBSTACLE_SIZE);
                bush.setPosition(x, y);
                obstacles.add(bush);
                break;
            case CRATE:
                Obstacle crate = new Obstacle(Assets.crate, OBSTACLE_SIZE, OBSTACLE_SIZE);
                crate.setPosition(x, y);
                obstacles.add(crate);
                break;
        }
    }
}