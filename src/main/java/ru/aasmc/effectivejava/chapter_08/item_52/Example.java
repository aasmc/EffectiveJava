package ru.aasmc.effectivejava.chapter_08.item_52;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Example {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = -3; i < 3; ++i) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; ++i) {
            // this makes use of autoboxing and converts i to Integer
            set.remove(i);
            // this uses overloaded version of remove(int index) and removes an element
            // at the specified index. To remove the element itself you need to
            // cast i to Integer = remove((Integer) i);
            list.remove(i);
        }
        System.out.println("Set: " + set);
        System.out.println("List" + list);
    }
}
