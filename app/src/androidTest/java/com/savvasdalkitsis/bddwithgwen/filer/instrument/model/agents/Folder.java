package com.savvasdalkitsis.bddwithgwen.filer.instrument.model.agents;

import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.tasks.ArrangeWith;
import com.shazam.gwen.gwt.Given;

public class Folder implements Given<FolderArrangements> {
    private final FolderArrangements folderArrangements;
    private String absolutePath;

    public Folder(ArrangeWith arrangeWith, String absolutePath) {
        this.absolutePath = absolutePath;
        folderArrangements = new FolderArrangements(arrangeWith);
    }

    @Override
    public FolderArrangements given() {
        return folderArrangements;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }
}
