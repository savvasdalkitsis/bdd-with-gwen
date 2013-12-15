package com.savvasdalkitsis.bdd.gwen.filer.fetcher.directory;

import com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryContents;

public interface DirectoryListener {
    void onDirectoryContentsLoaded(DirectoryContents data);
}
