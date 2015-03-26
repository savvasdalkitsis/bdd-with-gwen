package com.savvasdalkitsis.bddwithgwen.filer.instrument.tests;

import com.savvasdalkitsis.bddwithgwen.filer.instrument.FilerInstrumentationTestCase;

import org.junit.Test;

import static com.savvasdalkitsis.bddwithgwen.filer.instrument.beans.TestFiles.SOME_FILES;
import static com.shazam.gwen.Gwen.given;
import static com.shazam.gwen.Gwen.then;

public class FolderTest extends FilerInstrumentationTestCase {

    @Test
    public void displaysFiles() {
        given(folder).contains(SOME_FILES);
        given(user).isViewing(folder);

        then(user).sees(SOME_FILES);
    }
}
