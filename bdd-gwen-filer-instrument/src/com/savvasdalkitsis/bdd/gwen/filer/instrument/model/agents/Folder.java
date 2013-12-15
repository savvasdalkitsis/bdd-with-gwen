package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents;

import com.shazam.gwen.collaborators.Arranger;

import java.io.File;
import java.util.List;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.arrangements.ArrangementsModule.containsFilesArrangement;

public class Folder implements Arranger {
    private File dir;

    public Folder(File dir) {
        this.dir = dir;
    }

    public void contains(List<String> fileNames) {
        containsFilesArrangement(fileNames).arrangeWith(dir);
    }

    public String getAbsolutePath() {
        return dir.getAbsolutePath();
    }
}
