package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.actions;

import com.jayway.android.robotium.solo.Solo;
import com.savvasdalkitsis.bdd.gwen.filer.R;
import com.shazam.gwen.tasks.Action;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.longClick;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class EspressoDeleteFileAction implements Action<Solo, Void> {
    private String fileName;

    public EspressoDeleteFileAction(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Void actOn(Solo objectToActOn) {
        onView(withText(fileName))
                .perform(longClick());
        onView(withId(R.id.delete))
                .perform(click());
        return null;
    }
}
