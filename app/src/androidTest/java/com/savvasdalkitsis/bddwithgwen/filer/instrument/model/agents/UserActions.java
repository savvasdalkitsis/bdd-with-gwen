package com.savvasdalkitsis.bddwithgwen.filer.instrument.model.agents;

import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.tasks.ActOn;

import static com.savvasdalkitsis.bddwithgwen.filer.instrument.module.model.actions.ActionsModule.createNewFolderAction;
import static com.savvasdalkitsis.bddwithgwen.filer.instrument.module.model.actions.ActionsModule.deleteFileAction;
import static com.savvasdalkitsis.bddwithgwen.filer.instrument.module.model.actions.ActionsModule.opensFolderAction;

public class UserActions {
    private final ActOn actOn;

    public UserActions(ActOn actOn) {
        this.actOn = actOn;
    }
    public void opens(String folder) {
        actOn.solo(opensFolderAction(folder));
    }

    public void deletesFile(String fileName) {
        actOn.solo(deleteFileAction(fileName));
    }

    public void createsNewFolder(String folder) {
        actOn.solo(createNewFolderAction(folder));
    }
}
