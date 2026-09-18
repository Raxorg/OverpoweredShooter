package com.gdxjam38.opshooter.logic;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.gdxjam38.opshooter.Assets;

import java.util.Objects;

import static com.gdxjam38.opshooter.Constants.MATCH_TIME_LIMIT;

public class MatchTimer {
    public static MatchTimer instance;
    private final Label timer;

    private float currentTime = MATCH_TIME_LIMIT;
    private boolean isCounting = false;

    public MatchTimer(Stage stage) {
        Objects.requireNonNull(stage);
        this.timer = new Label("", Assets.skin);

        Table table = new Table();
        table.top();
        table.add(timer);
        table.setFillParent(true);
        stage.addActor(table);
        instance = this;
    }

    public void update(float delta) {
        if (isCounting) currentTime = Math.max(currentTime - delta, 0);
        updateLabel();
    }

    public void setCounting(boolean isCounting) {
        this.isCounting = isCounting;
    }

    public void resetCounter() {
        setCounting(false);
        currentTime = MATCH_TIME_LIMIT;
    }

    public boolean isTimeOver() {
        return currentTime <= 0;
    }

    private String buildLabelText() {
        return "Timer: " + (int) currentTime;
    }

    private void updateLabel() {
        timer.setText(buildLabelText());
    }
}
