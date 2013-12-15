package com.savvasdalkitsis.bdd.gwen.android.directory;

import android.app.FragmentManager;
import com.savvasdalkitsis.bdd.gwen.android.fragment.DirectoryFragment;
import com.savvasdalkitsis.bdd.gwen.model.directory.DirectoryEntryHandler;
import com.savvasdalkitsis.bdd.gwen.model.directory.DirectoryEntry;

public class FragmentDirectoryDisplayer implements DirectoryEntryHandler {

    private FragmentManager fragmentManager;

    public FragmentDirectoryDisplayer(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void handle(DirectoryEntry entry) {
        fragmentManager.beginTransaction()
                .replace(android.R.id.content,
                        DirectoryFragment.newInstance(entry.getAbsolutePath(), entry.getShortName()))
                .addToBackStack(null)
                .commit();
    }
}
