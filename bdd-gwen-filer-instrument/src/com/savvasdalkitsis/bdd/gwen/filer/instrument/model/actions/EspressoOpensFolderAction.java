package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.actions;

import com.jayway.android.robotium.solo.Solo;
import com.shazam.gwen.tasks.Action;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class EspressoOpensFolderAction implements Action<Solo, Void> {
    private String folder;

    public EspressoOpensFolderAction(String folder) {
        this.folder = folder;
    }

    @Override
    public Void actOn(Solo solo) {
        onView(withText(folder))
                .perform(click());
        return null;
    }
}
