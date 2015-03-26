package com.savvasdalkitsis.bddwithgwen.filer.fetcher;

public interface Fetcher<D, L> {
    void fetch(D data, L listener);
}
