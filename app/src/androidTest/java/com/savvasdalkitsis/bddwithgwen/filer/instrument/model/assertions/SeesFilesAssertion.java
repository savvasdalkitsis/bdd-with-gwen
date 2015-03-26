package com.savvasdalkitsis.bddwithgwen.filer.instrument.model.assertions;

import com.jayway.android.robotium.solo.Solo;
import com.shazam.gwen.tasks.Assertion;

import java.util.List;

import static com.savvasdalkitsis.bddwithgwen.filer.instrument.matchers.SoloMatchers.canSeeText;
import static org.hamcrest.MatcherAssert.assertThat;

public class SeesFilesAssertion implements Assertion<Solo> {
    private List<String> fileNames;

    public SeesFilesAssertion(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    @Override
    public void assertWith(Solo solo) {
        for (String fileName : fileNames) {
            assertThat(solo, canSeeText(fileName));
        }
    }
}
