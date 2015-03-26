package com.savvasdalkitsis.bddwithgwen.filer.instrument.model.agents;

import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.tasks.ActOn;
import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.tasks.ArrangeWith;
import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.tasks.AssertWith;
import com.shazam.gwen.gwt.Given;
import com.shazam.gwen.gwt.Then;
import com.shazam.gwen.gwt.When;

public class User implements Given<UserArrangements>, When<UserActions>, Then<UserAssertions> {
    private final UserArrangements userArrangements;
    private final UserActions userActions;
    private final UserAssertions userAssertions;

    public User(ArrangeWith arrangeWith, ActOn actOn, AssertWith assertWith) {
        userArrangements = new UserArrangements(arrangeWith);
        userActions = new UserActions(actOn);
        userAssertions = new UserAssertions(assertWith);
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
