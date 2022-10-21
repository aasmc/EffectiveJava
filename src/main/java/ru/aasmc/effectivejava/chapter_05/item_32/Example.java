package ru.aasmc.effectivejava.chapter_05.item_32;

import java.util.ArrayList;
import java.util.List;

public class Example {

    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> l : lists) {
            result.addAll(l);
        }
        return result;
    }
}
