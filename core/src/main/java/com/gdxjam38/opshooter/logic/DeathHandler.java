package com.gdxjam38.opshooter.logic;

import com.badlogic.gdx.math.Vector2;
import com.gdxjam38.opshooter.stuff.player.Player;

import java.util.Objects;
import java.util.Random;

public class DeathHandler {

    private final Vector2[][] respawnPoints = new Vector2[2][5];
    private final Player[] players;
    public final int[] deathCount = new int[2];
    private final Random random = new Random();

    public DeathHandler(Player[] players) {
        this.players = Objects.requireNonNull(players, "players cannot be null");
        respawnPoints[0][0] = new Vector2(300, 350);
        respawnPoints[0][1] = new Vector2(50, 50);
        respawnPoints[0][2] = new Vector2(50, 650);
        respawnPoints[0][3] = new Vector2(550, 50);
        respawnPoints[0][4] = new Vector2(550, 650);

        respawnPoints[1][0] = new Vector2(900, 350);
        respawnPoints[1][1] = new Vector2(650, 50);
        respawnPoints[1][2] = new Vector2(650, 650);
        respawnPoints[1][3] = new Vector2(1150, 50);
        respawnPoints[1][4] = new Vector2(1150, 650);
    }

    public void update(){
        int deadPlayer = checkForDeath();
        if (deadPlayer < 0) return;
        handleDeath(deadPlayer);
    }
    private int checkForDeath(){
        for (int i = 0; i < players.length; i++) {
            if (players[i].health.isDead()) return i;
        }
        return -1;
    }

    private void handleDeath(int i){
        int position = random.nextInt(respawnPoints[i].length);
        players[i].health.resetHp();
        players[i].hitBox.setPosition(respawnPoints[i][position]);
        deathCount[i]++;
    }
}
