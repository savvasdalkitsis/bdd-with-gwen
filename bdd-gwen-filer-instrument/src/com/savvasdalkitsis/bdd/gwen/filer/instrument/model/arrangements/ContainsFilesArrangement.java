package com.savvasdalkitsis.bdd.gwen.filer.instrument.model.arrangements;

import com.shazam.gwen.tasks.Arrangement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ContainsFilesArrangement implements Arrangement<File> {

    public static final String SEPARATOR = ", ";
    private List<String> fileNames;

    public ContainsFilesArrangement(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    @Override
    public void arrangeWith(File directory) {
        for (String fileName : fileNames) {
            try {
                boolean created = new File(directory, fileName).createNewFile();
                if (!created) {
                    error(directory, null);
                }
            } catch (IOException e) {
                error(directory, e);
            }
        }
    }

    private void error(File directory, IOException e) {
        throw new RuntimeException("Could not create files " + files() + " in directory " + directory.getAbsolutePath(), e);
    }

    private String files() {
        StringBuilder s = new StringBuilder();
        for (String fileName : fileNames) {
            s.append(fileName).append(SEPARATOR);
        }
        s.setLength(s.length() - SEPARATOR.length());
        return s.toString();
    }
}
