package ru.aasmc.effectivejava.chapter_12.item_85;

import java.util.HashSet;
import java.util.Set;

public class EternalDeserialization {
    /**
     * Example of a deserialization process that would take forever to complete,
     * resulting in a DoS.
     *
     * The object graph consists of 201 HashSet instances, each of which contains
     * 3 or fewer object references. The entire stream is 5,744 bytes long, yet
     * the sun would burn out long before you could deserialize it. the problem is that
     * deserializing a HashSet instance requires computing the hash codes of its
     * elements. The 2 elements of the root hash set are themselves hash sets
     * containing 2 hash-set elements, each of which contains 2 has-set elements and so on,
     * 100 levels deep. Therefore, deserializing the set causes the hashCode method to
     * be invoked 2^100 times.
     * @return
     */
    static byte[] bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            // Make t1 unequal to t2
            t1.add("foo");
            s1.add(t1); s1.add(t2);
            s2.add(t1); s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
        return serialize(root);
    }

    /**
     * Stub method.
     */
    private static byte[] serialize(Set<Object> root) {
        return new byte[10];
    }
}
