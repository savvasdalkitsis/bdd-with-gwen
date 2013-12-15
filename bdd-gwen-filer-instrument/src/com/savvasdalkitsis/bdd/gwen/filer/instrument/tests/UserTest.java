package com.savvasdalkitsis.bdd.gwen.filer.instrument.tests;

import com.savvasdalkitsis.bdd.gwen.filer.instrument.FilerInstrumentationTestCase;

import static com.savvasdalkitsis.bdd.gwen.filer.instrument.beans.TestFiles.*;
import static com.shazam.gwen.Gwen.*;

public class UserTest extends FilerInstrumentationTestCase {

    public void testCanNavigateToSubFolders() {
        given(folder).containsFolder(SUB_FOLDER);
        given(user).isViewing(folder);

        when(user).opens(SUB_FOLDER);

        then(user).isIn(SUB_FOLDER);
    }

    public void testCanDeleteFiles() throws Exception {
        given(folder).contains(SOME_FILES);
        given(user).isViewing(folder);

        when(user).deletesFile(FILE_1);

        then(user).cannotSee(FILE_1);
    }
}
