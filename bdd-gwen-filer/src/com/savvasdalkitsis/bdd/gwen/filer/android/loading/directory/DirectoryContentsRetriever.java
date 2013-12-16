package com.savvasdalkitsis.bdd.gwen.filer.android.loading.directory;

import com.savvasdalkitsis.bdd.gwen.filer.android.loading.loader.DataRetriever;
import com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryContents;
import com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryEntry;
import com.savvasdalkitsis.bdd.gwen.filer.util.Function;
import com.sun.istack.internal.Nullable;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryContents.Builder.directoryContents;
import static com.savvasdalkitsis.bdd.gwen.filer.util.Transformation.transform;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.sort;

public class DirectoryContentsRetriever implements DataRetriever<DirectoryContents> {

    private DirectoryFetcherData data;

    public DirectoryContentsRetriever(DirectoryFetcherData data) {
        this.data = data;
    }

    @Override
    public DirectoryContents retrieveData() {
        File directory = new File(data.getAbsolutePath());
        File[] files = directory.listFiles(onlyFiles());
        File[] directories = directory.listFiles(onlyDirectories());
        return directoryContents()
                .withFiles(sorted(entriesFrom(files, asFileEntry())))
                .withDirectories(sorted(entriesFrom(directories, asDirectoryEntry())))
                .build();
    }

    private List<DirectoryEntry> sorted(List<DirectoryEntry> directoryEntries) {
        ArrayList<DirectoryEntry> list = new ArrayList<DirectoryEntry>(directoryEntries);
        sort(list, byName());
        return list;
    }

    private Comparator<? super DirectoryEntry> byName() {
        return new Comparator<DirectoryEntry>() {
            @Override
            public int compare(DirectoryEntry lhs, DirectoryEntry rhs) {
                return lhs.getShortName().compareTo(rhs.getShortName());
            }
        };
    }

    private List<DirectoryEntry> entriesFrom(File[] files, Function<File, DirectoryEntry> transformation) {
        if (files == null) {
            return emptyList();
        }
        return transform(asList(files), transformation);
    }

    private Function<File, DirectoryEntry> asDirectoryEntry() {
        return new Function<File, DirectoryEntry>() {
            @Override
            public DirectoryEntry apply(@Nullable File file) {
                return DirectoryEntry.directoryFrom(file);
            }
        };
    }

    private Function<File, DirectoryEntry> asFileEntry() {
        return new Function<File, DirectoryEntry>() {
            @Override
            public DirectoryEntry apply(@Nullable File file) {
                return DirectoryEntry.fileFrom(file);
            }
        };
    }

    private FileFilter onlyDirectories() {
        return new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
    }

    private FileFilter onlyFiles() {
        return new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile();
            }
        };
    }
}
