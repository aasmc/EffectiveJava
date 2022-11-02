package ru.aasmc.effectivejava.chapter_11.item_79;

@FunctionalInterface public interface SetObserver<E> {
    void added(CorrectObservableSet<E> set, E element);
}
