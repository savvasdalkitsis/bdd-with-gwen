package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents;

import android.content.Context;
import com.jayway.android.robotium.solo.Solo;
import com.shazam.gwen.collaborators.Actor;
import com.shazam.gwen.collaborators.Arranger;
import com.shazam.gwen.collaborators.Asserter;

import java.util.List;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.actions.ActionsModule.opensFolderAction;
import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.arrangements.ArrangementsModule.viewFolderArrangement;
import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.assertions.AssertionsModule.isInFolderAssertion;
import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.assertions.AssertionsModule.seesFilesAssertion;

public class User implements Asserter, Arranger, Actor {
    private Context targetContext;
    private Solo solo;

    public User(Context targetContext, Solo solo) {
        this.targetContext = targetContext;
        this.solo = solo;
    }

    public void isViewing(Folder folder) {
        viewFolderArrangement(folder).arrangeWith(targetContext);
    }

    public void sees(List<String> fileNames) {
        seesFilesAssertion(fileNames).assertWith(solo);
    }

    public void opens(String folder) {
        opensFolderAction(folder).actOn(solo);
    }

    public void isIn(String folder) {
        isInFolderAssertion(folder).assertWith(solo);
    }

}
