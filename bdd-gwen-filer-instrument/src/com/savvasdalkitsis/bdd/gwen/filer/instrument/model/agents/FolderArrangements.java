package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents;

import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.tasks.ArrangeWith;

import java.util.List;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.arrangements.ArrangementsModule.containsFilesArrangement;
import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.arrangements.ArrangementsModule.containsFolderArrangement;

public class FolderArrangements {
    private final ArrangeWith arrangeWith;

    public FolderArrangements(ArrangeWith arrangeWith) {
        this.arrangeWith = arrangeWith;
    }

    public void containsFolder(String folderName) {
        arrangeWith.baseDirectory(containsFolderArrangement(folderName));
    }

    public void contains(List<String> fileNames) {
        arrangeWith.baseDirectory(containsFilesArrangement(fileNames));
    }
}
