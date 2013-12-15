package com.savvasdalkitsis.bdd.gwen.model.file;

import com.savvasdalkitsis.bdd.gwen.model.directory.DirectoryEntry;

import java.io.File;

public class FileDeleter implements DirectoryEntryDeleter {
    @Override
    public boolean delete(DirectoryEntry entry) {
        return new File(entry.getAbsolutePath()).delete();
    }
}
