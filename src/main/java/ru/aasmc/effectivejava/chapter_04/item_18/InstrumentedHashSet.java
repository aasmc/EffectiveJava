package ru.aasmc.effectivejava.chapter_04.item_18;

import java.util.Collection;
import java.util.HashSet;

/**
 * Broken class - inappropriate use of inheritance.
 * @param <E>
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    /**
     * When calling this method, addCount will be incorrect, because under the hood,
     * HashSet invokes its add method. Therefore, if we add a List.of(1, 2, 3) to
     * our InstrumentedHashSet, the addCount will be 6 instead of 3.
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
