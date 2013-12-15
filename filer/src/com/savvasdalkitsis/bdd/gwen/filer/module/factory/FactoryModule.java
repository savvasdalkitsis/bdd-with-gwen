package com.savvasdalkitsis.bdd.gwen.filer.module.factory;

import android.app.FragmentManager;
import android.app.LoaderManager;
import com.savvasdalkitsis.bdd.gwen.filer.factory.Factory;
import com.savvasdalkitsis.bdd.gwen.filer.android.directory.FileEntryHandler;
import com.savvasdalkitsis.bdd.gwen.filer.fetcher.Fetcher;
import com.savvasdalkitsis.bdd.gwen.filer.android.loading.directory.DirectoryContentsFetcher;
import com.savvasdalkitsis.bdd.gwen.filer.android.loading.directory.DirectoryFetcherData;
import com.savvasdalkitsis.bdd.gwen.filer.fetcher.directory.DirectoryListener;
import com.savvasdalkitsis.bdd.gwen.filer.android.directory.FragmentDirectoryDisplayer;
import com.savvasdalkitsis.bdd.gwen.filer.model.directory.DirectoryEntryHandler;

import static com.savvasdalkitsis.bdd.gwen.filer.module.ApplicationModule.application;
import static com.savvasdalkitsis.bdd.gwen.filer.module.model.MessageDisplayerModule.messageDisplayer;

public class FactoryModule {
    public static Factory<LoaderManager, Fetcher<DirectoryFetcherData, DirectoryListener>> directoryFetcherFactory() {
        return new Factory<LoaderManager, Fetcher<DirectoryFetcherData, DirectoryListener>>() {
            @Override
            public Fetcher<DirectoryFetcherData, DirectoryListener> create(LoaderManager from) {
                return new DirectoryContentsFetcher(application(), from);
            }
        };
    }

    public static Factory<FragmentManager, DirectoryEntryHandler> directoryDisplayerFactory() {
        return new Factory<FragmentManager, DirectoryEntryHandler>() {
            @Override
            public DirectoryEntryHandler create(FragmentManager from) {
                return new FragmentDirectoryDisplayer(from);
            }
        };
    }

    public static Factory<FragmentManager, DirectoryEntryHandler> fileDisplayerFactory() {
        return new Factory<FragmentManager, DirectoryEntryHandler>() {
            @Override
            public DirectoryEntryHandler create(FragmentManager from) {
                return new FileEntryHandler(application(), messageDisplayer());
            }
        };
    }

}
