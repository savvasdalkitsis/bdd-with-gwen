package com.savvasdalkitsis.bddwithgwen.filer.android.directory;

import android.app.FragmentManager;

import com.savvasdalkitsis.bddwithgwen.filer.android.fragment.DirectoryFragment;
import com.savvasdalkitsis.bddwithgwen.filer.model.directory.DirectoryEntry;
import com.savvasdalkitsis.bddwithgwen.filer.model.directory.DirectoryEntryHandler;

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
