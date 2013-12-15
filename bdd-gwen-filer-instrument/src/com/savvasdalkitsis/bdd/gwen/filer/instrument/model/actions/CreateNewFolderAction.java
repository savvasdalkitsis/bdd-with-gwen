package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.actions;

import android.widget.EditText;
import com.jayway.android.robotium.solo.Solo;
import com.savvasdalkitsis.bdd.gwen.filer.R;
import com.shazam.gwen.tasks.Action;

public class CreateNewFolderAction implements Action<Solo, Void> {
    private String folder;

    public CreateNewFolderAction(String folder) {
        this.folder = folder;
    }

    @Override
    public Void actOn(Solo solo) {
        solo.clickOnActionBarItem(R.id.new_item);
        EditText editText = (EditText) solo.getView(R.id.new_folder_edit_text);
        solo.enterText(editText, folder);
        solo.clickOnButton("OK");
        return null;
    }
}
