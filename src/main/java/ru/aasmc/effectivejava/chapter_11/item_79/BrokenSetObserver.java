package ru.aasmc.effectivejava.chapter_11.item_79;

@FunctionalInterface
public interface BrokenSetObserver<E> {
    void added(BrokenObservableSet<E> set, E element);
}
