package com.gdxjam38.opshooter;

import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class ShooterGame extends Game {
    @Override
    public void create() {
        setScreen(new FirstScreen());
    }
}