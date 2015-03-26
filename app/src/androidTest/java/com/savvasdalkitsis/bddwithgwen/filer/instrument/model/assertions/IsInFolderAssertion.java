package com.savvasdalkitsis.bddwithgwen.filer.instrument.model.assertions;

import com.jayway.android.robotium.solo.Solo;
import com.shazam.gwen.tasks.Assertion;

import static com.savvasdalkitsis.bddwithgwen.filer.instrument.matchers.SoloMatchers.hasActivityTitle;
import static org.hamcrest.MatcherAssert.assertThat;

public class IsInFolderAssertion implements Assertion<Solo> {

    private String folder;

    public IsInFolderAssertion(String folder) {
        this.folder = folder;
    }

    @Override
    public void assertWith(Solo solo) {
        solo.waitForText(folder);
        assertThat(solo, hasActivityTitle(folder));
    }

}