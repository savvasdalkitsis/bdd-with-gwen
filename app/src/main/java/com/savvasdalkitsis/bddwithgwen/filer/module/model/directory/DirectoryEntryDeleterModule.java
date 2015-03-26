package com.savvasdalkitsis.bddwithgwen.filer.module.model.directory;

import com.savvasdalkitsis.bddwithgwen.filer.model.directory.DirectoryEntryDeleter;
import com.savvasdalkitsis.bddwithgwen.filer.model.directory.FileDeleter;

public class DirectoryEntryDeleterModule {
    public static DirectoryEntryDeleter deleter() {
        return new FileDeleter();
    }
}
