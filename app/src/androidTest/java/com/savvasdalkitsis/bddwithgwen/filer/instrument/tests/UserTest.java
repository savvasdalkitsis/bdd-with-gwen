package com.savvasdalkitsis.bddwithgwen.filer.instrument.tests;

import com.savvasdalkitsis.bddwithgwen.filer.instrument.FilerInstrumentationTestCase;

import org.junit.Test;

import static com.savvasdalkitsis.bddwithgwen.filer.instrument.beans.TestFiles.FILE_1;
import static com.savvasdalkitsis.bddwithgwen.filer.instrument.beans.TestFiles.NEW_FOLDER;
import static com.savvasdalkitsis.bddwithgwen.filer.instrument.beans.TestFiles.SOME_FILES;
import static com.savvasdalkitsis.bddwithgwen.filer.instrument.beans.TestFiles.SUB_FOLDER;
import static com.shazam.gwen.Gwen.given;
import static com.shazam.gwen.Gwen.then;
import static com.shazam.gwen.Gwen.when;

public class UserTest extends FilerInstrumentationTestCase {

    @Test
    public void canNavigateToSubFolders() {
        given(folder).containsFolder(SUB_FOLDER);
        given(user).isViewing(folder);

        when(user).opens(SUB_FOLDER);

        then(user).isIn(SUB_FOLDER);
    }

    @Test
    public void canDeleteFiles() throws Exception {
        given(folder).contains(SOME_FILES);
        given(user).isViewing(folder);

        when(user).deletesFile(FILE_1);

        then(user).cannotSee(FILE_1);
    }

    @Test
    public void canCreateNewFolder() throws Exception {
        given(user).isViewing(folder);

        when(user).createsNewFolder(NEW_FOLDER);

        then(user).sees(NEW_FOLDER);

        when(user).opens(NEW_FOLDER);

        then(user).isIn(NEW_FOLDER);
    }
}
