package com.savvasdalkitsis.bddwithgwen.filer.instrument.model.assertions;

import com.jayway.android.robotium.solo.Solo;
import com.shazam.gwen.tasks.Assertion;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import static org.hamcrest.MatcherAssert.assertThat;

public class CannotSeeFileAssertion implements Assertion<Solo> {
    private String fileName;

    public CannotSeeFileAssertion(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void assertWith(Solo solo) {
        assertThat(solo, cannotSeeText(fileName));
    }

    private Matcher<? super Solo> cannotSeeText(final String text) {
        return new TypeSafeDiagnosingMatcher<Solo>() {
            @Override
            protected boolean matchesSafely(Solo item, Description mismatchDescription) {
                mismatchDescription.appendText("text was found on screen");
                return !item.searchText(fileName);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("text ").appendText(text).appendText(" to not be visible");
            }
        };
    }
}
