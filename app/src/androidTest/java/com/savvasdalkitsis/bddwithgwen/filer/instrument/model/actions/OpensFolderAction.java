package com.savvasdalkitsis.bddwithgwen.filer.instrument.model.actions;

import com.jayway.android.robotium.solo.Solo;
import com.shazam.gwen.tasks.Action;

import static com.savvasdalkitsis.bddwithgwen.filer.instrument.matchers.SoloMatchers.canSeeText;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpensFolderAction implements Action<Solo, Void> {

    private String folder;

    public OpensFolderAction(String folder) {
        this.folder = folder;
    }

    @Override
    public Void actOn(Solo solo) {
        assertThat(solo, canSeeText(folder));
        solo.clickOnText(folder);
        return null;
    }
}
