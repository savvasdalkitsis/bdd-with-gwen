package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.assertions;

import com.jayway.android.robotium.solo.Solo;
import com.shazam.gwen.tasks.Assertion;

import java.util.List;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class EspressoSeesFilesAssertion implements Assertion<Solo> {
    private List<String> fileNames;

    public EspressoSeesFilesAssertion(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    @Override
    public void assertWith(Solo objectUsedToPerformAssertion) {
        for (String fileName : fileNames) {
            onView(withText(fileName))
                    .check(matches(withText(fileName)));
        }
    }
}
