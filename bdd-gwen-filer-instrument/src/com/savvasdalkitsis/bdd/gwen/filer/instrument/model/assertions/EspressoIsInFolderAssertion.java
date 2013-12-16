package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.assertions;

import com.jayway.android.robotium.solo.Solo;
import com.shazam.gwen.tasks.Assertion;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.hasDescendant;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static com.savvasdalkitsis.bdd.gwen.filer.instrument.matchers.ViewMatchers.withId;

public class EspressoIsInFolderAssertion implements Assertion<Solo> {
    private String folder;

    public EspressoIsInFolderAssertion(String folder) {
        this.folder = folder;
    }

    @Override
    public void assertWith(Solo objectUsedToPerformAssertion) {
        onView(withId("android.R.id.action_bar"))
                .check(matches(hasDescendant(withText(folder))));
    }
}
