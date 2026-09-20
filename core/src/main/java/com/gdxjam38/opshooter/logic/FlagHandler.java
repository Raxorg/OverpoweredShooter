package com.gdxjam38.opshooter.logic;

import static com.gdxjam38.opshooter.Constants.TILE_SIZE;

import com.badlogic.gdx.math.Vector2;
import com.gdxjam38.opshooter.stuff.Flag;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;

public class FlagHandler {

    private final Vector2 playerAux, flagAux;
    private final Flag redFlag, blueFlag;
    private final Player bluePlayer, redPlayer;

    public FlagHandler(Stuff stuff) {
        playerAux = new Vector2();
        flagAux = new Vector2();
        redFlag = stuff.getRedFlag();
        blueFlag = stuff.getBlueFlag();
        bluePlayer = stuff.getPlayer1();
        redPlayer = stuff.getPlayer2();
    }

    public void update() {
        updateCarryStatus();
        updateFlagPosition(redFlag, bluePlayer);
        updateFlagPosition(blueFlag, redPlayer);
    }

    private void updateCarryStatus() {
        float distance = bluePlayer.getCenter(playerAux).dst(redFlag.getCenter(flagAux));
        if (distance <= TILE_SIZE) {
            carry(redFlag);
        }
        distance = redPlayer.getCenter(playerAux).dst(blueFlag.getCenter(flagAux));
        if (distance <= TILE_SIZE) {
            carry(blueFlag);
        }
    }

    private void updateFlagPosition(Flag flag, Player player) {
        if (flag.isCaptured()) {
            player.getCenter(playerAux);
            flag.setPosition(playerAux.x, playerAux.y);
        }
    }

    private void carry(Flag flag) {
        flag.setCarried(true);
    }

    // TODO: 9/20/2026 Call when player dies
    public void drop(Flag flag) {
        if (!flag.isCaptured()) return;

        flag.setCarried(false);
    }
}