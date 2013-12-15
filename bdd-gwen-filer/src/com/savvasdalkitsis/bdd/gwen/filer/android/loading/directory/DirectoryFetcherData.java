package com.savvasdalkitsis.bdd.gwen.filer.android.loading.directory;

public class DirectoryFetcherData {
    private String absolutePath;

    public DirectoryFetcherData(Builder builder) {
        absolutePath = builder.absolutePath;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public static class Builder {

        private String absolutePath;

        public static Builder directoryFetcherData() {
            return new Builder();
        }

        public Builder withAbsolutePath(String absolutePath) {
            this.absolutePath = absolutePath;
            return this;
        }

        public DirectoryFetcherData build() {
            return new DirectoryFetcherData(this);
        }
    }
}
