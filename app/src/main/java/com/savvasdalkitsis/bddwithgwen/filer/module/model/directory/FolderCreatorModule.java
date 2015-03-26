package com.savvasdalkitsis.bddwithgwen.filer.module.model.directory;

import android.app.Activity;

import com.savvasdalkitsis.bddwithgwen.filer.android.directory.DialogFolderCreator;
import com.savvasdalkitsis.bddwithgwen.filer.factory.Factory;
import com.savvasdalkitsis.bddwithgwen.filer.model.directory.FolderCreator;

public class FolderCreatorModule {
    public static Factory<Activity, FolderCreator> folderCreator() {
        return new Factory<Activity, FolderCreator>() {
            @Override
            public FolderCreator create(Activity activity) {
                return new DialogFolderCreator(activity);
            }
        };
    }
}
