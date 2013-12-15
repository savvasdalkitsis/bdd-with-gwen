package com.savvasdalkitsis.bdd.gwen.filer.fetcher;

public interface Fetcher<D, L> {
    void fetch(D data, L listener);
}
