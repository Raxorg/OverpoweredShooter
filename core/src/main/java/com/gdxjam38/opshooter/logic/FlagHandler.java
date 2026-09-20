package com.gdxjam38.opshooter.logic;

import static com.gdxjam38.opshooter.Constants.TILE_SIZE;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam38.opshooter.stuff.Flag;
import com.gdxjam38.opshooter.stuff.Stuff;
import com.gdxjam38.opshooter.stuff.player.Player;

public class FlagHandler {

    private final Vector2 playerAux, flagAux;
    private final Flag redFlag, blueFlag;
    private final Player bluePlayer, redPlayer;
    private final Sprite blueFlagPlatform, redFlagPlatform;

    public FlagHandler(Stuff stuff) {
        playerAux = new Vector2();
        flagAux = new Vector2();
        redFlag = stuff.getRedFlag();
        blueFlag = stuff.getBlueFlag();
        bluePlayer = stuff.getPlayer1();
        redPlayer = stuff.getPlayer2();
        blueFlagPlatform = stuff.getBlueFlagPlatform();
        redFlagPlatform = stuff.getRedFlagPlatform();
    }

    public void update() {
        updateCarryStatus();
        updateFlagPosition(redFlag, bluePlayer);
        updateFlagPosition(blueFlag, redPlayer);
        checkFlagSteal(blueFlagPlatform, bluePlayer, redFlag);
        checkFlagSteal(redFlagPlatform, redPlayer, blueFlag);
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
        if (flag.isCarried()) {
            player.getCenter(playerAux);
            flag.setPosition(playerAux.x, playerAux.y);
        }
    }

    private void carry(Flag flag) {
        flag.setCarried(true);
        // TODO: 9/20/2026 Make player slower
    }

    public void dropFlag(Player player) {
        Flag flag = player == bluePlayer ? redFlag : blueFlag;
        if (!flag.isCarried()) return;

        flag.setCarried(false);
    }

    private void checkFlagSteal(Sprite flagPlatform, Player player, Flag flag) {
        float x = flagPlatform.getX() + flagPlatform.getOriginX();
        float y = flagPlatform.getY() + flagPlatform.getOriginY();
        flagAux.set(x, y);
        float distance = player.getCenter(playerAux).dst(flagAux);
        if (distance <= TILE_SIZE && flag.isCarried()) {
            captureFlag(flag, flagPlatform);
        }
    }

    private void captureFlag(Flag flag, Sprite flagPlatform) {
        Sprite enemyPlatform = flagPlatform == blueFlagPlatform ? redFlagPlatform : blueFlagPlatform;
        flag.setPosition(enemyPlatform.getX(), enemyPlatform.getY());
        flag.setCarried(false);
    }
}