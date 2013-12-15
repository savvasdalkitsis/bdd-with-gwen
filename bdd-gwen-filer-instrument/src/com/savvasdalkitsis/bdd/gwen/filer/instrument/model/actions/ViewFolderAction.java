package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.actions;

import android.content.Context;
import android.content.Intent;
import com.savvasdalkitsis.bdd.gwen.filer.android.activity.FilerActivity;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents.Folder;
import com.shazam.gwen.tasks.Action;

public class ViewFolderAction implements Action<Context, Void> {
    private Folder folder;

    public ViewFolderAction(Folder folder) {
        this.folder = folder;
    }

    @Override
    public Void actOn(Context context) {
        Intent intent = new Intent(context, FilerActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("com.savvasdalkitsis.bdd.gwen.filer.PARAM_INITIAL_PATH", folder.getAbsolutePath());
        context.startActivity(intent);
        return null;
    }
}
