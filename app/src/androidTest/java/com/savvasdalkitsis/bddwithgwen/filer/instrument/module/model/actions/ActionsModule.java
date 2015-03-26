package com.savvasdalkitsis.bddwithgwen.filer.instrument.module.model.actions;

import com.jayway.android.robotium.solo.Solo;
import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.actions.CreateNewFolderAction;
import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.actions.DeleteFileAction;
import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.actions.OpensFolderAction;
import com.shazam.gwen.tasks.Action;

public class ActionsModule {
    public static Action<Solo, ?> opensFolderAction(String folder) {
        return new OpensFolderAction(folder);
    }

    public static Action<Solo, ?> deleteFileAction(String fileName) {
        return new DeleteFileAction(fileName);
    }

    public static Action<Solo, ?> createNewFolderAction(String folder) {
        return new CreateNewFolderAction(folder);
    }
}
