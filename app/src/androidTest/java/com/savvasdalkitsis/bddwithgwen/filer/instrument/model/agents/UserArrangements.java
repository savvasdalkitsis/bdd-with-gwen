package com.savvasdalkitsis.bddwithgwen.filer.instrument.model.agents;

import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.tasks.ArrangeWith;

import static com.savvasdalkitsis.bddwithgwen.filer.instrument.module.model.arrangements.ArrangementsModule.viewFolderArrangement;

public class UserArrangements {
    private final ArrangeWith arrangeWith;

    public UserArrangements(ArrangeWith arrangeWith) {
        this.arrangeWith = arrangeWith;
    }
    public void isViewing(Folder folder) {
        arrangeWith.targetContext(viewFolderArrangement(folder));
    }
}
