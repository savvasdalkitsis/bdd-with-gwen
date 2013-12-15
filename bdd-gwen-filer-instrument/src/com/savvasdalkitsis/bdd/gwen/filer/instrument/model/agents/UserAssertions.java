package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents;

import com.jayway.android.robotium.solo.Solo;

import java.util.List;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.assertions.AssertionsModule.*;

public class UserAssertions {
    private Solo solo;

    public UserAssertions(Solo solo) {
        this.solo = solo;
    }

    public void sees(List<String> fileNames) {
        seesFilesAssertion(fileNames).assertWith(solo);
    }

    public void isIn(String folder) {
        isInFolderAssertion(folder).assertWith(solo);
    }

    public void cannotSee(String fileName) {
        cannotSeeFileAssertion(fileName).assertWith(solo);
    }
}
