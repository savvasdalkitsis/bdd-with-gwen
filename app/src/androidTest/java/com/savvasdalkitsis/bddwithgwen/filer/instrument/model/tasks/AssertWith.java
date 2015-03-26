package com.savvasdalkitsis.bddwithgwen.filer.instrument.model.tasks;

import com.jayway.android.robotium.solo.Solo;
import com.shazam.gwen.tasks.Assertion;

public class AssertWith {
    private Solo solo;

    public AssertWith(Solo solo) {
        this.solo = solo;
    }

    public void solo(Assertion<Solo> soloAssertion) {
        soloAssertion.assertWith(solo);
    }
}
