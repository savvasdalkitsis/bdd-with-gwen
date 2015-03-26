package com.savvasdalkitsis.bddwithgwen.filer.fetcher.directory;

import com.savvasdalkitsis.bddwithgwen.filer.model.directory.DirectoryContents;

public interface DirectoryListener {
    void onDirectoryContentsLoaded(DirectoryContents data);
}
