package com.savvasdalkitsis.bdd.gwen.module.model.directory;

import com.savvasdalkitsis.bdd.gwen.model.directory.DirectoryEntryDeleter;
import com.savvasdalkitsis.bdd.gwen.model.directory.FileDeleter;

public class DirectoryEntryDeleterModule {
    public static DirectoryEntryDeleter deleter() {
        return new FileDeleter();
    }
}
