package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents;

import android.content.Context;
import com.jayway.android.robotium.solo.Solo;
import com.shazam.gwen.gwt.Given;
import com.shazam.gwen.gwt.Then;
import com.shazam.gwen.gwt.When;

public class User implements Given<UserArrangements>, When<UserActions>, Then<UserAssertions> {
    private final UserArrangements userArrangements;
    private final UserActions userActions;
    private final UserAssertions userAssertions;

    public User(Context targetContext, Solo solo) {
        userArrangements = new UserArrangements(targetContext);
        userActions = new UserActions(solo);
        userAssertions = new UserAssertions(solo);
    }

    @Override
    public UserArrangements given() {
        return userArrangements;
    }

    @Override
    public UserActions when() {
        return userActions;
    }

    @Override
    public UserAssertions then() {
        return userAssertions;
    }
}
