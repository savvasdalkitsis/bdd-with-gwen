package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents;

import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.tasks.ActOn;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.actions.ActionsModule.*;

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
