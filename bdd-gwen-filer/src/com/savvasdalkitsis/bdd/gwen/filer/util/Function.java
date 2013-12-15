package com.savvasdalkitsis.bdd.gwen.filer.util;

public interface Function<F, T> {
    public T transform(F from);
}
