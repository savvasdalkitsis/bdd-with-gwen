package com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.assertions;

import com.jayway.android.robotium.solo.Solo;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.assertions.CannotSeeFileAssertion;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.assertions.IsInFolderAssertion;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.assertions.SeesFilesAssertion;
import com.shazam.gwen.tasks.Assertion;

import java.util.List;

public class AssertionsModule {
    public static Assertion<Solo> seesFilesAssertion(List<String> fileNames) {
        return new SeesFilesAssertion(fileNames);
    }

    public static Assertion<Solo> isInFolderAssertion(String folder) {
        return new IsInFolderAssertion(folder);
    }

    public static Assertion<Solo> cannotSeeFileAssertion(String fileName) {
        return new CannotSeeFileAssertion(fileName);
    }
}
