package com.savvasdalkitsis.bdd.gwen.filer.android.directory;

import com.savvasdalkitsis.bdd.gwen.filer.FilerApplication;
import com.savvasdalkitsis.bdd.gwen.filer.R;
import com.savvasdalkitsis.bdd.gwen.filer.model.MessageDisplayer;
import com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryEntry;
import com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryEntryHandler;

public class FileEntryHandler implements DirectoryEntryHandler {

    private final FilerApplication context;
    private final MessageDisplayer messageDisplayer;

    public FileEntryHandler(FilerApplication context, MessageDisplayer messageDisplayer) {
        this.context = context;
        this.messageDisplayer = messageDisplayer;
    }

    @Override
    public void handle(DirectoryEntry entry) {
        messageDisplayer.showMessage(context.getString(R.string.file_handling_not_supported));
    }
}
