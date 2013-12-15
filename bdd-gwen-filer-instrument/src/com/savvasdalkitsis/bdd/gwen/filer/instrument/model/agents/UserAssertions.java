package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents;

import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.tasks.AssertWith;

import java.util.List;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.assertions.AssertionsModule.*;

public class UserAssertions {
    private final AssertWith assertWith;

    public UserAssertions(AssertWith assertWith) {
        this.assertWith = assertWith;
    }

    public void sees(List<String> fileNames) {
        assertWith.solo(seesFilesAssertion(fileNames));
    }

    public void isIn(String folder) {
        assertWith.solo(isInFolderAssertion(folder));
    }

    public void cannotSee(String fileName) {
        assertWith.solo(cannotSeeFileAssertion(fileName));
    }
}
