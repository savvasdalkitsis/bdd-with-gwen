package com.savvasdalkitsis.bdd.gwen.module.model.file;

import com.savvasdalkitsis.bdd.gwen.model.file.DirectoryEntryDeleter;
import com.savvasdalkitsis.bdd.gwen.model.file.FileDeleter;

public class DirectoryEntryDeleterModule {
    public static DirectoryEntryDeleter deleter() {
        return new FileDeleter();
    }
}
