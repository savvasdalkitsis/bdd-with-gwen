package com.savvasdalkitsis.bddwithgwen.filer.instrument;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.jayway.android.robotium.solo.Solo;
import com.savvasdalkitsis.bddwithgwen.filer.android.activity.FilerActivity;
import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.agents.Folder;
import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.agents.User;
import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.tasks.ActOn;
import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.tasks.ArrangeWith;
import com.savvasdalkitsis.bddwithgwen.filer.instrument.model.tasks.AssertWith;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(AndroidJUnit4.class)
public class FilerInstrumentationTestCase extends ActivityInstrumentationTestCase2<FilerActivity> {

    protected Folder folder;
    protected User user;
    private Solo solo;

    public FilerInstrumentationTestCase() {
        super(FilerActivity.class);
    }

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        injectInstrumentation(instrumentation);
        Context targetContext = instrumentation.getTargetContext();
        File externalCacheDir = targetContext.getExternalCacheDir();
        clear(externalCacheDir);
        ArrangeWith arrangeWith = new ArrangeWith(targetContext, externalCacheDir);
        folder = new Folder(arrangeWith, externalCacheDir.getAbsolutePath());
        solo = new Solo(instrumentation);
        user = new User(arrangeWith, new ActOn(solo), new AssertWith(solo));
    }

    @Override
    @After
    public void tearDown() throws Exception {
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
