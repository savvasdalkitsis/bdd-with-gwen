package com.savvasdalkitsis.bdd.gwen.filer.model.directory;

public interface FolderCreator {
    void createNewFolder(String basePath, FolderCreationListener listener);
}
