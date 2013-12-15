package com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.actions;

import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.actions.ViewFolderAction;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents.Folder;

public class ActionsModule {
    public static ViewFolderAction viewFolderAction(Folder folder) {
        return new ViewFolderAction(folder);
    }
}
