package ru.aasmc.effectivejava.chapter_05.item_26;

import java.util.ArrayList;
import java.util.List;

public class Example {
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        unsafeAdd(strings, Integer.valueOf(42));
//        saferAdd(strings, Integer.valueOf(42)); // Doesn't compile
//        String s = strings.get(0); // throws ClassCastException at runtime
    }

    private static void saferAdd(List<Object> list, Object o) {
        list.add(o);
    }
}
