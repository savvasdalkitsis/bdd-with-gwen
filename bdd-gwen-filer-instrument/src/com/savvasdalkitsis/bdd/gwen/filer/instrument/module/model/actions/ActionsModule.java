package com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.actions;

import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.actions.DeleteFileAction;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.actions.OpensFolderAction;

public class ActionsModule {
    public static OpensFolderAction opensFolderAction(String folder) {
        return new OpensFolderAction(folder);
    }

    public static DeleteFileAction deleteFileAction(String fileName) {
        return new DeleteFileAction(fileName);
    }
}
