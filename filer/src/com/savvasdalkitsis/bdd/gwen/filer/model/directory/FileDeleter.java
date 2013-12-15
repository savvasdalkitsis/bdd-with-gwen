package com.savvasdalkitsis.bdd.gwen.filer.model.directory;

import java.io.File;

public class FileDeleter implements DirectoryEntryDeleter {
    @Override
    public boolean delete(DirectoryEntry entry) {
        return new File(entry.getAbsolutePath()).delete();
    }
}
