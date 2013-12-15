package com.savvasdalkitsis.bdd.gwen.filer.instrument;

import android.app.Instrumentation;
import android.content.Context;
import android.test.InstrumentationTestCase;
import android.util.Log;
import com.jayway.android.robotium.solo.Solo;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents.Folder;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents.User;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.tasks.ActOn;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.tasks.ArrangeWith;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.tasks.AssertWith;

import java.io.File;

public class FilerInstrumentationTestCase extends InstrumentationTestCase {
    protected Folder folder;
    protected User user;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Instrumentation instrumentation = getInstrumentation();
        Context targetContext = instrumentation.getTargetContext();
        File externalCacheDir = targetContext.getExternalCacheDir();
        clear(externalCacheDir);
        ArrangeWith arrangeWith = new ArrangeWith(targetContext, externalCacheDir);
        folder = new Folder(arrangeWith, externalCacheDir.getAbsolutePath());
        final Solo solo = new Solo(instrumentation);
        user = new User(arrangeWith, new ActOn(solo), new AssertWith(solo));
    }

    private void clear(File dir) {
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                delete(file);
            } else {
                clear(file);
                delete(file);
            }
        }
    }

    private void delete(File file) {
        boolean deleted = file.delete();
        if (!deleted) {
            Log.w(FilerInstrumentationTestCase.class.getName(), "Failed to delete file " + file.getAbsolutePath());
        }
    }
}
