package com.savvasdalkitsis.bdd.gwen.filer.util;

import java.util.ArrayList;
import java.util.List;

public class Transformation {
    public static <F, T> List<T> transform(List<F> from, Function<F, T> transformation) {
        ArrayList<T> result = new ArrayList<T>();
        for (F f : from) {
            result.add(transformation.apply(f));
        }
        return result;
    }
}
