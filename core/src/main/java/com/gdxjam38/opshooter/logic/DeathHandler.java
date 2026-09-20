package com.gdxjam38.opshooter.logic;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.gdxjam38.opshooter.stuff.RespawnPoint;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;

public class DeathHandler {

    private final Array<Player> players;
    private final Array<RespawnPoint> blueRespawnPoints, redRespawnPoints;
    public final int[] deathCount = new int[2];
    private final Vector2 aux;

    private FlagHandler flagHandler;

    public DeathHandler(Stuff stuff) {
        players = stuff.getPlayers();
        blueRespawnPoints = stuff.getBlueRespawnPoints();
        redRespawnPoints = stuff.getRedRespawnPoints();
        aux = new Vector2();
    }

    public void update() {
        checkDeaths();
    }

    private void checkDeaths() {
        for (int i = 0; i < players.size; i++) {
            if (players.get(i).health.isDead()) {
                Array<RespawnPoint> respawnPoints = i == 0 ? blueRespawnPoints : redRespawnPoints;
                handleDeath(players.get(i), respawnPoints);
                deathCount[i]++;
            }
        }
    }

    private void handleDeath(Player player, Array<RespawnPoint> respawnPoints) {
        RespawnPoint respawnPoint = respawnPoints.random();
        player.health.resetHp();
        respawnPoint.getPosition(aux);
        player.setPosition(aux.x, aux.y);
        flagHandler.dropFlag(player);
    }

    public void setFlagHandler(FlagHandler flagHandler) {
        this.flagHandler = flagHandler;
    }
}