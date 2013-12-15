package com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.arrangements;

import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.arrangements.ContainsFilesArrangement;

import java.util.List;

public class ArrangementsModule {
    public static ContainsFilesArrangement containsFilesArrangement(List<String> fileNames) {
        return new ContainsFilesArrangement(fileNames);
    }
}
