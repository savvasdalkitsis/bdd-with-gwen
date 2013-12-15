package com.savvasdalkitsis.bdd.gwen.filer.module.model.directory;

import android.app.Activity;
import com.savvasdalkitsis.bdd.gwen.filer.factory.Factory;
import com.savvasdalkitsis.bdd.gwen.filer.android.directory.DialogFolderCreator;
import com.savvasdalkitsis.bdd.gwen.filer.model.directory.FolderCreator;

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
