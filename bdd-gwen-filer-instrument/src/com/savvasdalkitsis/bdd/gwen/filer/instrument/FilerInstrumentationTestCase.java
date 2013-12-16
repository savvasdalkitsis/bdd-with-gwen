package com.savvasdalkitsis.bdd.gwen.filer.instrument;

import android.app.Instrumentation;
import android.content.Context;
import android.test.InstrumentationTestCase;
import android.util.Log;
import com.jayway.android.robotium.solo.Solo;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents.Folder;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents.User;

import java.io.File;

public class FilerInstrumentationTestCase extends InstrumentationTestCase {
    protected Folder folder;
    protected User user;
    private Solo solo;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Instrumentation instrumentation = getInstrumentation();
        Context targetContext = instrumentation.getTargetContext();
        File externalCacheDir = targetContext.getExternalCacheDir();
        clear(externalCacheDir);
        folder = new Folder(externalCacheDir);
        solo = new Solo(instrumentation);
        user = new User(targetContext, solo);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        solo.getCurrentActivity().finish();
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
