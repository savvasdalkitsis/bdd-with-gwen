package com.savvasdalkitsis.bddwithgwen.filer.android.loading.directory;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;

import com.savvasdalkitsis.bddwithgwen.filer.android.loading.loader.TypeLoader;
import com.savvasdalkitsis.bddwithgwen.filer.fetcher.Fetcher;
import com.savvasdalkitsis.bddwithgwen.filer.fetcher.directory.DirectoryListener;
import com.savvasdalkitsis.bddwithgwen.filer.model.directory.DirectoryContents;

public class DirectoryContentsFetcher implements Fetcher<DirectoryFetcherData, DirectoryListener>,
        LoaderManager.LoaderCallbacks<DirectoryContents> {

    private final Context context;
    private LoaderManager loaderManager;
    private DirectoryFetcherData data;
    private DirectoryListener directoryListener;

    public DirectoryContentsFetcher(Context context, LoaderManager loaderManager) {
        this.loaderManager = loaderManager;
        this.context = context;
    }

    @Override
    public void fetch(DirectoryFetcherData data, DirectoryListener directoryListener) {
        this.data = data;
        this.directoryListener = directoryListener;
        loaderManager.restartLoader(0, null, this);
    }

    @Override
    public Loader<DirectoryContents> onCreateLoader(int id, Bundle args) {
        return new TypeLoader<>(context, new DirectoryContentsRetriever(data));
    }

    @Override
    public void onLoadFinished(Loader<DirectoryContents> loader, DirectoryContents data) {
        directoryListener.onDirectoryContentsLoaded(data);
    }

    @Override
    public void onLoaderReset(Loader<DirectoryContents> loader) {}
}
