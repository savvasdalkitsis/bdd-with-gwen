package com.savvasdalkitsis.bdd.gwen.filer.instrument.matchers;

import android.view.View;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class ViewMatchers {
    public static Matcher<View> withId(final String id) {
        return new TypeSafeDiagnosingMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item, Description mismatchDescription) {
                String itemId = item.getResources().getResourceEntryName(item.getId());
                mismatchDescription.appendText("id was " + itemId);
                return id.equals(itemId);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("view with id " + id);
            }
        };
    }
}
