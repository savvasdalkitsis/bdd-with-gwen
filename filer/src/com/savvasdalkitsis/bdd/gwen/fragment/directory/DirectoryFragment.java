package com.savvasdalkitsis.bdd.gwen.fragment.directory;

import android.app.*;
import android.os.Bundle;
import android.view.*;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.common.collect.ImmutableMap;
import com.savvasdalkitsis.bdd.gwen.R;
import com.savvasdalkitsis.bdd.gwen.action.NoOpActionMode;
import com.savvasdalkitsis.bdd.gwen.factory.Factory;
import com.savvasdalkitsis.bdd.gwen.fetcher.Fetcher;
import com.savvasdalkitsis.bdd.gwen.fetcher.directory.DirectoryFetcherData;
import com.savvasdalkitsis.bdd.gwen.fetcher.directory.DirectoryListener;
import com.savvasdalkitsis.bdd.gwen.model.MessageDisplayer;
import com.savvasdalkitsis.bdd.gwen.model.directory.*;
import com.savvasdalkitsis.bdd.gwen.model.file.DirectoryEntryDeleter;

import java.util.Map;

import static com.savvasdalkitsis.bdd.gwen.fetcher.directory.DirectoryFetcherData.Builder.directoryFetcherData;
import static com.savvasdalkitsis.bdd.gwen.model.directory.DirectoryEntry.Type.DIRECTORY;
import static com.savvasdalkitsis.bdd.gwen.model.directory.DirectoryEntry.Type.FILE;
import static com.savvasdalkitsis.bdd.gwen.module.factory.FactoryModule.*;
import static com.savvasdalkitsis.bdd.gwen.module.model.MessageDisplayerModule.messageDisplayer;
import static com.savvasdalkitsis.bdd.gwen.module.model.directory.FolderCreatorModule.folderCreator;
import static com.savvasdalkitsis.bdd.gwen.module.model.file.DirectoryEntryDeleterModule.deleter;

public class DirectoryFragment extends ListFragment implements DirectoryListener, AdapterView.OnItemLongClickListener, ActionMode.Callback, FolderCreationListener {

    private static final String PARAM_PATH = DirectoryFragment.class.getName() + "._PARAM_PATH";
    private static final String PARAM_DIR_NAME = DirectoryFragment.class.getName() + ".PARAM_DIR_NAME";

    private Fetcher<DirectoryFetcherData, DirectoryListener> directoryContentsFetcher;
    private DirectoryListAdapter adapter;
    private Factory<LoaderManager, Fetcher<DirectoryFetcherData, DirectoryListener>> fetcherFactory;
    private Factory<FragmentManager, DirectoryEntryHandler> directoryDisplayerFactory;
    private Factory<FragmentManager, DirectoryEntryHandler> fileDisplayerFactory;
    private Map<DirectoryEntry.Type,DirectoryEntryHandler> handlers;
    private ActionMode actionMode = NoOpActionMode.NO_OP;
    private DirectoryEntry selectedItem;
    private DirectoryEntryDeleter directoryEntryDeleter;
    private FolderCreator folderCreator;
    private final Factory<Activity,FolderCreator> folderCreatorFactory;
    private final MessageDisplayer messageDisplayer;

    public static Fragment newInstance(String absolutePath, String directoryName) {
        DirectoryFragment fragment = new DirectoryFragment();
        fragment.setArguments(new Bundle());
        fragment.setAbsolutePath(absolutePath);
        fragment.setDirectoryName(directoryName);
        return fragment;
    }

    public DirectoryFragment() {
        this(directoryFetcherFactory(), directoryDisplayerFactory(), fileDisplayerFactory(), deleter(), folderCreator(), messageDisplayer());
    }

    public DirectoryFragment(Factory<LoaderManager, Fetcher<DirectoryFetcherData, DirectoryListener>> fetcherFactory,
                             Factory<FragmentManager, DirectoryEntryHandler> directoryDisplayerFactory,
                             Factory<FragmentManager, DirectoryEntryHandler> fileDisplayerFactory, DirectoryEntryDeleter directoryEntryDeleter, Factory<Activity, FolderCreator> folderCreatorFactory, MessageDisplayer messageDisplayer) {
        this.fetcherFactory = fetcherFactory;
        this.directoryDisplayerFactory = directoryDisplayerFactory;
        this.fileDisplayerFactory = fileDisplayerFactory;
        this.folderCreatorFactory = folderCreatorFactory;
        this.directoryEntryDeleter = directoryEntryDeleter;
        this.messageDisplayer = messageDisplayer;
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
        handlers = ImmutableMap.of(
                DIRECTORY, directoryDisplayerFactory.create(getFragmentManager()),
                FILE, fileDisplayerFactory.create(getFragmentManager())
        );
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
        messageDisplayer.showMessage("Could not create folder");
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
