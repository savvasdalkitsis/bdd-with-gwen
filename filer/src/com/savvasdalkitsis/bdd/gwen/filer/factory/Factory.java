package com.savvasdalkitsis.bdd.gwen.filer.factory;

public interface Factory<F, T> {

    T create(F from);
}
