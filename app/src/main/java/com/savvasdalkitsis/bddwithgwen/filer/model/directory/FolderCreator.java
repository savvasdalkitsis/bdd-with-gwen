package com.savvasdalkitsis.bddwithgwen.filer.model.directory;

public interface FolderCreator {
    void createNewFolder(String basePath, FolderCreationListener listener);
}
