package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.tasks;

import com.jayway.android.robotium.solo.Solo;
import com.shazam.gwen.tasks.Action;

public class ActOn {
    private Solo solo;

    public ActOn(Solo solo) {
        this.solo = solo;
    }

    public void solo(Action<Solo, ?> soloAction) {
        soloAction.actOn(solo);
    }
}
