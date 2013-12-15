package com.savvasdalkitsis.bdd.gwen.module.model.directory;

import android.app.Activity;
import com.savvasdalkitsis.bdd.gwen.factory.Factory;
import com.savvasdalkitsis.bdd.gwen.fragment.directory.DialogFolderCreator;
import com.savvasdalkitsis.bdd.gwen.model.directory.FolderCreator;

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
