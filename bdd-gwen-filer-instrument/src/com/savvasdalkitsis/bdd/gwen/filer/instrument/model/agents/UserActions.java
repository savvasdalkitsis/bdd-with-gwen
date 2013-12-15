package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents;

import com.jayway.android.robotium.solo.Solo;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.actions.ActionsModule.opensFolderAction;

public class UserActions {
    private Solo solo;

    public UserActions(Solo solo) {
        this.solo = solo;
    }
    public void opens(String folder) {
        opensFolderAction(folder).actOn(solo);
    }
}
