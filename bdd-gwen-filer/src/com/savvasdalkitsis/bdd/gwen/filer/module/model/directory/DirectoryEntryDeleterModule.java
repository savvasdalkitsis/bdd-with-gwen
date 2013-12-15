package com.savvasdalkitsis.bdd.gwen.filer.module.model.directory;

import com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryEntryDeleter;
import com.savvasdalkitsis.bdd.gwen.filer.model.directory.FileDeleter;

public class DirectoryEntryDeleterModule {
    public static DirectoryEntryDeleter deleter() {
        return new FileDeleter();
    }
}
