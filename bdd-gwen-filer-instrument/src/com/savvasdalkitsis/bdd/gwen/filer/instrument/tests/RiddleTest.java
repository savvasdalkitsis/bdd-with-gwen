package com.savvasdalkitsis.bdd.gwen.filer.instrument.tests;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import com.jayway.android.robotium.solo.Solo;
import com.savvasdalkitsis.bdd.gwen.filer.android.activity.FilerActivity;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.FilerInstrumentationTestCase;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.matchers.SoloMatchers.canSeeText;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;

public class RiddleTest extends FilerInstrumentationTestCase {

    public static final List<String> SOME_FILES = asList("file1.txt", "file2.txt");

    public void testNotGoingToTellYou() {
        Instrumentation instrumentation = getInstrumentation();
        Context context = instrumentation.getTargetContext();
        Solo solo = new Solo(instrumentation);

        File base = context.getExternalCacheDir();
        for (String fileName : SOME_FILES) {
            try {
                boolean created = new File(base, fileName).createNewFile();
                if (!created) {
                    error(base, null, fileName);
                }
            } catch (IOException e) {
                error(base, e, null);
            }
        }

        Intent intent = new Intent(context, FilerActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("com.savvasdalkitsis.bdd.gwen.filer.PARAM_INITIAL_PATH", folder.getAbsolutePath());
        context.startActivity(intent);


        for (String fileName : SOME_FILES) {
            assertThat(solo, canSeeText(fileName));
        }
    }


    private void error(File directory, IOException e, String file) {
        throw new RuntimeException("Could not create files " + file + " in directory " + directory.getAbsolutePath(), e);
    }

}
