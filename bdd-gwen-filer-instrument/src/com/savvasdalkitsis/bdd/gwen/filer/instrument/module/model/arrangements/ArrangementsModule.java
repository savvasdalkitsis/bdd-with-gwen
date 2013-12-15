package com.savvasdalkitsis.bdd.gwen.filer.instrument.module.model.arrangements;

import android.content.Context;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.agents.Folder;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.arrangements.ContainsFilesArrangement;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.arrangements.ContainsFolderArrangement;
import com.savvasdalkitsis.bdd.gwen.filer.instrument.model.arrangements.ViewFolderArrangement;
import com.shazam.gwen.tasks.Arrangement;

import java.util.List;

public class ArrangementsModule {
    public static ContainsFilesArrangement containsFilesArrangement(List<String> fileNames) {
        return new ContainsFilesArrangement(fileNames);
    }

    public static Arrangement<Context> viewFolderArrangement(Folder folder) {
        return new ViewFolderArrangement(folder);
    }

    public static ContainsFolderArrangement containsFolderArrangement(String folderName) {
        return new ContainsFolderArrangement(folderName);
    }
}
