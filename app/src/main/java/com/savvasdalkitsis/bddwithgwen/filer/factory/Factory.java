package com.savvasdalkitsis.bddwithgwen.filer.factory;

public interface Factory<F, T> {

    T create(F from);
}
