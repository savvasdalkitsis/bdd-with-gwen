package com.savvasdalkitsis.bddwithgwen.filer.instrument.model.arrangements;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;

import com.savvasdalkitsis.bddwithgwen.filer.android.activity.FilerActivity;
import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.agents.Folder;
import com.shazam.gwen.tasks.Arrangement;

public class ViewFolderArrangement implements Arrangement<Context> {
    private Folder folder;

    public ViewFolderArrangement(Folder folder) {
        this.folder = folder;
    }

    @Override
    public void arrangeWith(Context context) {
        Intent intent = new Intent(context, FilerActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("com.savvasdalkitsis.bdd.gwen.filer.PARAM_INITIAL_PATH", folder.getAbsolutePath());
        context.startActivity(intent);
    }
}
