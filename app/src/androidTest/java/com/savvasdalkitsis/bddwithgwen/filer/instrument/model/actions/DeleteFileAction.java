package com.savvasdalkitsis.bddwithgwen.filer.instrument.model.actions;

import com.jayway.android.robotium.solo.Solo;
import com.savvasdalkitsis.bddwithgwen.R;
import com.shazam.gwen.tasks.Action;

public class DeleteFileAction implements Action<Solo, Void> {
    private String fileName;

    public DeleteFileAction(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Void actOn(Solo solo) {
        solo.clickLongOnText(fileName);
        solo.clickOnView(solo.getView(R.id.delete));
        return null;
    }
}
