package com.savvasdalkitsis.bdd.gwen.filer.util;

import java.util.ArrayList;
import java.util.List;

public class Transformation {
    public static <F, T> List<T> transform(List<F> items, Function<F, T> transformation) {
        ArrayList<T> result = new ArrayList<T>();
        for (F item : items) {
            result.add(transformation.transform(item));
        }
        return result;
    }
}
