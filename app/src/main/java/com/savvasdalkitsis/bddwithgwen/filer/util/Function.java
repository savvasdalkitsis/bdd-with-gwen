package com.savvasdalkitsis.bddwithgwen.filer.util;

public interface Function<F, T> {
    public T transform(F from);
}
