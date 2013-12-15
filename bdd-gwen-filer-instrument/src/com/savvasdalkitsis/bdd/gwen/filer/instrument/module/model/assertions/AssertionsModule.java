package com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.assertions;

import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.assertions.IsInFolderAssertion;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.assertions.SeesFilesAssertion;

import java.util.List;

public class AssertionsModule {
    public static SeesFilesAssertion seesFilesAssertion(List<String> fileNames) {
        return new SeesFilesAssertion(fileNames);
    }

    public static IsInFolderAssertion isInFolderAssertion(String folder) {
        return new IsInFolderAssertion(folder);
    }
}
