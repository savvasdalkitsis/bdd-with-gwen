package com.savvasdalkitsis.bddwithgwen.filer.android.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.savvasdalkitsis.bddwithgwen.filer.model.directory.*;
import com.savvasdalkitsis.bddwithgwen.R;
import com.savvasdalkitsis.bddwithgwen.filer.android.action.NoOpActionMode;
import com.savvasdalkitsis.bddwithgwen.filer.android.loading.directory.DirectoryFetcherData;
import com.savvasdalkitsis.bddwithgwen.filer.factory.Factory;
import com.savvasdalkitsis.bddwithgwen.filer.fetcher.Fetcher;
import com.savvasdalkitsis.bddwithgwen.filer.fetcher.directory.DirectoryListener;
import com.savvasdalkitsis.bddwithgwen.filer.model.MessageDisplayer;
import com.savvasdalkitsis.bddwithgwen.filer.model.directory.DirectoryContents;
import com.savvasdalkitsis.bddwithgwen.filer.model.directory.DirectoryEntry;
import com.savvasdalkitsis.bddwithgwen.filer.model.directory.DirectoryEntryDeleter;
import com.savvasdalkitsis.bddwithgwen.filer.model.directory.DirectoryEntryHandler;
import com.savvasdalkitsis.bddwithgwen.filer.model.directory.FolderCreator;

import java.util.HashMap;
import java.util.Map;

import static com.savvasdalkitsis.bddwithgwen.filer.android.loading.directory.DirectoryFetcherData.Builder.directoryFetcherData;
import static com.savvasdalkitsis.bddwithgwen.filer.model.directory.DirectoryEntry.Type.DIRECTORY;
import static com.savvasdalkitsis.bddwithgwen.filer.model.directory.DirectoryEntry.Type.FILE;
import static com.savvasdalkitsis.bddwithgwen.filer.module.factory.FactoryModule.directoryDisplayerFactory;
import static com.savvasdalkitsis.bddwithgwen.filer.module.factory.FactoryModule.directoryFetcherFactory;
import static com.savvasdalkitsis.bddwithgwen.filer.module.factory.FactoryModule.fileDisplayerFactory;
import static com.savvasdalkitsis.bddwithgwen.filer.module.model.MessageDisplayerModule.messageDisplayer;
import static com.savvasdalkitsis.bddwithgwen.filer.module.model.directory.DirectoryEntryDeleterModule.deleter;
import static com.savvasdalkitsis.bddwithgwen.filer.module.model.directory.FolderCreatorModule.folderCreator;

public class DirectoryFragment extends ListFragment implements DirectoryListener, AdapterView.OnItemLongClickListener, ActionMode.Callback, FolderCreationListener {

    private static final String PARAM_PATH = DirectoryFragment.class.getName() + "._PARAM_PATH";
    private static final String PARAM_DIR_NAME = DirectoryFragment.class.getName() + ".PARAM_DIR_NAME";

    private final Factory<LoaderManager, Fetcher<DirectoryFetcherData, DirectoryListener>> fetcherFactory = directoryFetcherFactory();
    private final Factory<FragmentManager, DirectoryEntryHandler> directoryDisplayerFactory = directoryDisplayerFactory();
    private final Factory<FragmentManager, DirectoryEntryHandler> fileDisplayerFactory = fileDisplayerFactory();
    private final DirectoryEntryDeleter directoryEntryDeleter = deleter();
    private final Factory<Activity,FolderCreator> folderCreatorFactory = folderCreator();
    private final MessageDisplayer messageDisplayer = messageDisplayer();
    private Map<DirectoryEntry.Type,DirectoryEntryHandler> handlers;
    private ActionMode actionMode = NoOpActionMode.NO_OP;
    private DirectoryEntry selectedItem;
    private FolderCreator folderCreator;
    private Fetcher<DirectoryFetcherData, DirectoryListener> directoryContentsFetcher;
    private DirectoryListAdapter adapter;

    public static Fragment newInstance(String absolutePath, String directoryName) {
        DirectoryFragment fragment = new DirectoryFragment();
        fragment.setArguments(new Bundle());
        fragment.setAbsolutePath(absolutePath);
        fragment.setDirectoryName(directoryName);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setEmptyText(getString(R.string.no_files_to_display));
        getListView().setOnItemLongClickListener(this);
        getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        directoryContentsFetcher = fetcherFactory.create(getLoaderManager());
        folderCreator = folderCreatorFactory.create(activity);
        handlers = new HashMap<DirectoryEntry.Type, DirectoryEntryHandler>();
        handlers.put(DIRECTORY, directoryDisplayerFactory.create(getFragmentManager()));
        handlers.put(FILE, fileDisplayerFactory.create(getFragmentManager()));
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(getDirectoryName());
        loadContents();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_directory, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_item:
                folderCreator.createNewFolder(getAbsolutePath(), this);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onDirectoryContentsLoaded(DirectoryContents data) {
        adapter = new DirectoryListAdapter(data);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        exitActionMode(true);
        onEntryClicked(adapter.getItem(position));
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        if (actionMode != NoOpActionMode.NO_OP) {
            return false;
        }
        selectedItem = adapter.getItem(position);
        actionMode = getActivity().startActionMode(this);
        getListView().setItemChecked(position, true);
        return true;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.menu_directory_action, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                directoryEntryDeleter.delete(selectedItem);
                loadContents();
                exitActionMode(true);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        exitActionMode(false);
    }

    @Override
    public void onNewFolderCreated() {
        loadContents();
    }

    @Override
    public void onNewFolderCreationFailed() {
        messageDisplayer.showMessage(getString(R.string.error_creating_folder));
    }

    private void onEntryClicked(DirectoryEntry directoryEntry) {
        handlers.get(directoryEntry.getType()).handle(directoryEntry);
    }

    private void setAbsolutePath(String absolutePath) {
        getArguments().putString(PARAM_PATH, absolutePath);
    }

    private String getAbsolutePath() {
        return getArguments().getString(PARAM_PATH);
    }

    private void setDirectoryName(String directoryName) {
        getArguments().putString(PARAM_DIR_NAME, directoryName);
    }

    private String getDirectoryName() {
        return getArguments().getString(PARAM_DIR_NAME);
    }

    private void loadContents() {
        directoryContentsFetcher.fetch(directoryFetcherData().withAbsolutePath(getAbsolutePath()).build(), this);
    }

    private void exitActionMode(boolean force) {
        selectedItem = null;
        if (force) {
            actionMode.finish();
        }
        actionMode = NoOpActionMode.NO_OP;
        final ListView listView = getListView();
        listView.clearChoices();
        for (int i = 0; i < listView.getChildCount(); i++) {
            listView.setItemChecked(i, false);
        }
    }
}
