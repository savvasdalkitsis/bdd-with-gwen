package com.savvasdalkitsis.bdd.gwen.model.directory;

public interface FolderCreator {
    void createNewFolder(String basePath, FolderCreationListener listener);
}
