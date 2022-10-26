package ru.aasmc.effectivejava.chapter_07.item_47;

import java.util.*;

public class PowerSet {
    // Returns the power set of an input set as custom collection
    // Power set of a given set is the set of all subsets from the given set,
    // including the empty set and the given set itself.
    // E.g. power set of {a, b, c} is:
    // {{}, {a}, {b}, {c}, {a,b}, {a,c}, {b,c}, {a,b,c}}
    // If a set has n elements, then its power set will contain
    // 2 ^ n elements.

    /**
     * This method uses the index of each element in the power set as a bit vector,
     * where the n-th bit in the index indicates the presence or absence of the n-th
     * element from the source set. In essence, there's a natural mapping between the binary
     * numbers from 0 to 2^n - 1 and the power set of an n-element set.
     */
    public static final <E> Collection<Set<E>> of(Set<E> s) {
        List<E> src = new ArrayList<>(s);
        if (src.size() > 30) {
            throw new IllegalArgumentException("Set too big " + s);
        }
        return new AbstractList<Set<E>>() {

            @Override
            public int size() {
                // 2 ^ N
                return 1 << src.size();
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set) o);
            }

            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1) {
                    if ((index & 1) == 1) {
                        result.add(src.get(i));
                    }
                }
                return result;
            }
        };
    }
}
