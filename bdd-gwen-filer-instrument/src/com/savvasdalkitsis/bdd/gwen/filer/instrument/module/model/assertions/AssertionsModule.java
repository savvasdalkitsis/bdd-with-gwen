package com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.assertions;

import com.jayway.android.robotium.solo.Solo;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.assertions.EspressoCannotSeeFileAssertion;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.assertions.EspressoIsInFolderAssertion;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.assertions.EspressoSeesFilesAssertion;
import com.shazam.gwen.tasks.Assertion;

import java.util.List;

public class AssertionsModule {
    public static Assertion<Solo> seesFilesAssertion(List<String> fileNames) {
//        return new SeesFilesAssertion(fileNames);
        return new EspressoSeesFilesAssertion(fileNames);
    }

    public static Assertion<Solo> isInFolderAssertion(String folder) {
//        return new IsInFolderAssertion(folder);
        return new EspressoIsInFolderAssertion(folder);
    }

    public static Assertion<Solo> cannotSeeFileAssertion(String fileName) {
//        return new CannotSeeFileAssertion(fileName);
        return new EspressoCannotSeeFileAssertion(fileName);
    }
}
