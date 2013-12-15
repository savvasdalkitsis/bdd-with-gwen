package com.savvasdalkitsis.bdd.gwen.filer.model.directory;

import java.io.File;

import static com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryEntry.Builder.directoryEntry;

public class DirectoryEntry {

    public static enum Type {
        FILE, DIRECTORY
    }

    private String absolutePath;
    private String shortName;
    private Type type;

    public DirectoryEntry(Builder builder) {
        absolutePath = builder.absolutePath;
        shortName = builder.shortName;
        type = builder.isFile ? Type.FILE : Type.DIRECTORY;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public String getShortName() {
        return shortName;
    }

    public Type getType() {
        return type;
    }

    public static DirectoryEntry fileFrom(File file) {
        return entry(file)
                .thatIsAFile()
                .build();
    }

    public static DirectoryEntry directoryFrom(File directory) {
        return entry(directory)
                .thatIsADirectory()
                .build();
    }

    private static Builder entry(File file) {
        return directoryEntry()
                .withAbsolutePath(file.getAbsolutePath())
                .withShortName(file.getName());
    }

    public static class Builder {

        private String absolutePath;
        private String shortName;
        private boolean isFile;

        public static Builder directoryEntry() {
            return new Builder();
        }

        public Builder withAbsolutePath(String absolutePath) {
            this.absolutePath = absolutePath;
            return this;
        }

        public Builder withShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public Builder thatIsAFile() {
            this.isFile = true;
            return this;
        }

        public Builder thatIsADirectory() {
            this.isFile = false;
            return this;
        }

        public DirectoryEntry build() {
            return new DirectoryEntry(this);
        }
    }
}
