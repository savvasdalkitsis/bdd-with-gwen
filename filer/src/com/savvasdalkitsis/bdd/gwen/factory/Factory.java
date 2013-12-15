package com.savvasdalkitsis.bdd.gwen.factory;

public interface Factory<F, T> {

    T create(F from);
}
