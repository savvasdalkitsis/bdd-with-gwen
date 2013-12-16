package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.actions;

import com.jayway.android.robotium.solo.Solo;
import com.savvasdalkitsis.bdd.gwen.filer.R;
import com.shazam.gwen.tasks.Action;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;


public class EspressoCreateNewFolderAction implements Action<Solo, Void> {
    private String folder;

    public EspressoCreateNewFolderAction(String folder) {
        this.folder = folder;
    }

    @Override
    public Void actOn(Solo objectToActOn) {
        onView(withId(R.id.new_folder_edit_text))
                .perform(typeText(folder));
        onView(withText("OK"))
                .perform(click());
        return null;
    }
}
