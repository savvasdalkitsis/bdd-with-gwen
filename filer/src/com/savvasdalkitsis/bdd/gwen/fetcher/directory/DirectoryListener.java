package com.savvasdalkitsis.bdd.gwen.fetcher.directory;

import com.savvasdalkitsis.bdd.gwen.model.directory.DirectoryContents;

public interface DirectoryListener {
    void onDirectoryContentsLoaded(DirectoryContents data);
}
