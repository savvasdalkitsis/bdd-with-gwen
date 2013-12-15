package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents;

import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.tasks.ArrangeWith;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.arrangements.ArrangementsModule.viewFolderArrangement;

public class UserArrangements {
    private final ArrangeWith arrangeWith;

    public UserArrangements(ArrangeWith arrangeWith) {
        this.arrangeWith = arrangeWith;
    }
    public void isViewing(Folder folder) {
        arrangeWith.targetContext(viewFolderArrangement(folder));
    }
}
