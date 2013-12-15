package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents;

import android.content.Context;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.arrangements.ArrangementsModule.viewFolderArrangement;

public class UserArrangements {
    private Context targetContext;

    public UserArrangements(Context targetContext) {
        this.targetContext = targetContext;
    }
    public void isViewing(Folder folder) {
        viewFolderArrangement(folder).arrangeWith(targetContext);
    }
}
