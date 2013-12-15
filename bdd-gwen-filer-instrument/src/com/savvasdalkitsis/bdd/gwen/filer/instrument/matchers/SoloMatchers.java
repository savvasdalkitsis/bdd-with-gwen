package com.savvasdalkitsis.bdd.gwen.filer.instrument.matchers;

import com.jayway.android.robotium.solo.Solo;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class SoloMatchers {
    public static Matcher<? super Solo> canSeeText(final String text) {
        return new TypeSafeDiagnosingMatcher<Solo>() {
            @Override
            protected boolean matchesSafely(Solo item, Description mismatchDescription) {
                mismatchDescription.appendText("Could not find text " + text);
                return item.searchText(text);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("text " + text + " to be on screen");
            }
        };
    }
}
