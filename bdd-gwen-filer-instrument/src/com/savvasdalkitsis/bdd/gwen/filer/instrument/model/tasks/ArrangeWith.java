package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.tasks;

import android.content.Context;
import com.shazam.gwen.tasks.Arrangement;

import java.io.File;

public class ArrangeWith {
    private Context targetContext;
    private File baseDirectory;

    public ArrangeWith(Context targetContext, File baseDirectory) {
        this.targetContext = targetContext;
        this.baseDirectory = baseDirectory;
    }

    public void targetContext(Arrangement<Context> contextArrangement) {
        contextArrangement.arrangeWith(targetContext);
    }

    public void baseDirectory(Arrangement<File> fileArrangement) {
        fileArrangement.arrangeWith(baseDirectory);
    }
}
