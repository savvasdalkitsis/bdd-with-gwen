package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents;

import java.io.File;
import java.util.List;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.arrangements.ArrangementsModule.containsFilesArrangement;
import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.arrangements.ArrangementsModule.containsFolderArrangement;

public class FolderArrangements {
    private File dir;

    public FolderArrangements(File dir) {
        this.dir = dir;
    }

    public void containsFolder(String folderName) {
        containsFolderArrangement(folderName).arrangeWith(dir);
    }

    public void contains(List<String> fileNames) {
        containsFilesArrangement(fileNames).arrangeWith(dir);
    }
}
