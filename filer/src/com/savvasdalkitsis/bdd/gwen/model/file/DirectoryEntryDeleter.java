package com.savvasdalkitsis.bdd.gwen.model.file;

import com.savvasdalkitsis.bdd.gwen.model.directory.DirectoryEntry;

public interface DirectoryEntryDeleter {
    boolean delete(DirectoryEntry entry);
}
