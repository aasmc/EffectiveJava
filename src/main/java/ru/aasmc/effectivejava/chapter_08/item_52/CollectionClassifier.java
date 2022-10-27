package ru.aasmc.effectivejava.chapter_08.item_52;

import java.math.BigInteger;
import java.util.*;

/**
 * Failed attempt to classify collections by type.
 */
public class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> s) {
        return "List";
    }

    public static String classify(Collection<?> s) {
        return "Unknown";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };
        // always prints unknown because the overloading is done at compile time,
        // and at compile time all collections are of type Collection<?>
        for (var c : collections) {
            System.out.println(classify(c));
        }
    }
}
