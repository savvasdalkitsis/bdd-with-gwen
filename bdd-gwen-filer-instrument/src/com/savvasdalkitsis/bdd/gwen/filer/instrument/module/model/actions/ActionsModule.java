package com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.actions;

import com.jayway.android.robotium.solo.Solo;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.actions.EspressoCreateNewFolderAction;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.actions.EspressoDeleteFileAction;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.actions.EspressoOpensFolderAction;
import com.shazam.gwen.tasks.Action;

public class ActionsModule {
    public static Action<Solo, ?> opensFolderAction(String folder) {
//        return new OpensFolderAction(folder);
        return new EspressoOpensFolderAction(folder);
    }

    public static Action<Solo, ?> deleteFileAction(String fileName) {
//        return new DeleteFileAction(fileName);
        return new EspressoDeleteFileAction(fileName);
    }

    public static Action<Solo, ?> createNewFolderAction(String folder) {
//        return new CreateNewFolderAction(folder);
        return new EspressoCreateNewFolderAction(folder);
    }
}
