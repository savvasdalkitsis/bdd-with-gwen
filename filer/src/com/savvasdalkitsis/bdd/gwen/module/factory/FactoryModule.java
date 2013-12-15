package com.savvasdalkitsis.bdd.gwen.module.factory;

import android.app.FragmentManager;
import android.app.LoaderManager;
import com.savvasdalkitsis.bdd.gwen.factory.Factory;
import com.savvasdalkitsis.bdd.gwen.factory.directory.FileEntryHandler;
import com.savvasdalkitsis.bdd.gwen.fetcher.Fetcher;
import com.savvasdalkitsis.bdd.gwen.fetcher.directory.DirectoryContentsFetcher;
import com.savvasdalkitsis.bdd.gwen.fetcher.directory.DirectoryFetcherData;
import com.savvasdalkitsis.bdd.gwen.fetcher.directory.DirectoryListener;
import com.savvasdalkitsis.bdd.gwen.fragment.directory.FragmentDirectoryDisplayer;
import com.savvasdalkitsis.bdd.gwen.model.directory.DirectoryEntryHandler;

import static com.savvasdalkitsis.bdd.gwen.module.ApplicationModule.application;
import static com.savvasdalkitsis.bdd.gwen.module.model.MessageDisplayerModule.messageDisplayer;

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
