package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents;

import android.content.Context;
import com.jayway.android.robotium.solo.Solo;
import com.shazam.gwen.collaborators.Actor;
import com.shazam.gwen.collaborators.Asserter;

import java.util.List;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.actions.ActionsModule.viewFolderAction;
import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.assertions.AssertionsModule.seesFilesAssertion;

public class User implements Actor, Asserter {
    private Context targetContext;
    private Solo solo;

    public User(Context targetContext, Solo solo) {
        this.targetContext = targetContext;
        this.solo = solo;
    }

    public void isViewing(Folder folder) {
        viewFolderAction(folder).actOn(targetContext);
    }

    public void sees(List<String> fileNames) {
        seesFilesAssertion(fileNames).assertWith(solo);
    }
}
