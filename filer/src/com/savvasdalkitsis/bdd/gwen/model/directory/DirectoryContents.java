package com.savvasdalkitsis.bdd.gwen.model.directory;

import java.util.ArrayList;
import java.util.List;

public class DirectoryContents {

    private List<DirectoryEntry> files;
    private List<DirectoryEntry> directories;
    private List<DirectoryEntry> combined;

    public DirectoryContents(Builder builder) {
        files = builder.files;
        directories = builder.directories;
        combined = new ArrayList<DirectoryEntry>(directories);
        combined.addAll(files);
    }

    public int itemCount() {
        return files.size() + directories.size();
    }

    public DirectoryEntry getEntry(int position) {
        return combined.get(position);
    }

    public static class Builder {

        private final ArrayList<DirectoryEntry> files = new ArrayList<DirectoryEntry>();
        private final ArrayList<DirectoryEntry> directories = new ArrayList<DirectoryEntry>();

        public static Builder directoryContents() {
            return new Builder();
        }

        public Builder withFiles(List<DirectoryEntry> files) {
            for (DirectoryEntry file : files) {
                withFile(file);
            }
            return this;
        }

        public Builder withFile(DirectoryEntry file) {
            files.add(file);
            return this;
        }

        public Builder withDirectories(List<DirectoryEntry> directories) {
            for (DirectoryEntry directory : directories) {
                withDirectory(directory);
            }
            return this;
        }

        public Builder withDirectory(DirectoryEntry directory) {
            directories.add(directory);
            return this;
        }

        public DirectoryContents build() {
            return new DirectoryContents(this);
        }
    }

}
