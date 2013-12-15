package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents;

import com.shazam.gwen.gwt.Given;

import java.io.File;

public class Folder implements Given<FolderArrangements> {
    private final FolderArrangements folderArrangements;
    private File dir;

    public Folder(File dir) {
        this.dir = dir;
        folderArrangements = new FolderArrangements(dir);
    }

    @Override
    public FolderArrangements given() {
        return folderArrangements;
    }

    public String getAbsolutePath() {
        return dir.getAbsolutePath();
    }
}
