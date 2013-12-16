package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.assertions;

import com.jayway.android.robotium.solo.Solo;
import com.shazam.gwen.tasks.Assertion;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.not;

public class EspressoCannotSeeFileAssertion implements Assertion<Solo> {
    private String fileName;

    public EspressoCannotSeeFileAssertion(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void assertWith(Solo objectUsedToPerformAssertion) {
        onView(isRoot())
                .check(matches(not(hasDescendant(withText(fileName)))));
    }
}
