package com.savvasdalkitsis.bdd.gwen.filer.instrument.tests;

import com.savvasdalkitsis.bdd.gwen.filer.instrument.FilerInstrumentationTestCase;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.beans.TestFiles.SOME_FILES;
import static com.shazam.gwen.Gwen.*;

public class FolderTest extends FilerInstrumentationTestCase {

    public void testDisplaysFiles() {
        given(folder).contains(SOME_FILES);
        given(user).isViewing(folder);

        then(user).sees(SOME_FILES);
    }
}
