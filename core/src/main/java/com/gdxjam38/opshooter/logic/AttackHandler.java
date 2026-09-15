package com.gdxjam38.opshooter.logic;

import com.gdxjam38.opshooter.stuff.AttackControl;
import com.gdxjam38.opshooter.stuff.Stuff;

public class AttackHandler {

    private final AttackControl attackControl;

    public AttackHandler(Stuff stuff) {
        attackControl = stuff.getAttackControl();
    }

    public void update(float delta) {
        attackControl.rotate(90f * delta);
    }
}
