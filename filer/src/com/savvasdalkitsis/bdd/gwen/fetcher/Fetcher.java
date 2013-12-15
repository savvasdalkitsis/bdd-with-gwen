package com.savvasdalkitsis.bdd.gwen.fetcher;

public interface Fetcher<D, L> {
    void fetch(D data, L listener);
}
