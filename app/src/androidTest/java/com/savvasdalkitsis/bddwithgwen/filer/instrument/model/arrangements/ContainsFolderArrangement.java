package com.savvasdalkitsis.bddwithgwen.filer.instrument.model.arrangements;

import com.shazam.gwen.tasks.Arrangement;

import java.io.File;

public class ContainsFolderArrangement implements Arrangement<File> {

    private String folderName;

    public ContainsFolderArrangement(String folderName) {
        this.folderName = folderName;
    }

    @Override
    public void arrangeWith(File baseDir) {
        boolean created = new File(baseDir, folderName).mkdir();
        if (!created) {
            throw new RuntimeException("Could not create folder " + folderName + " inside " + baseDir.getAbsolutePath());
        }
    }
}
