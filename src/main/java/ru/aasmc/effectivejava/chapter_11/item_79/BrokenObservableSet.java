package ru.aasmc.effectivejava.chapter_11.item_79;

import ru.aasmc.effectivejava.chapter_04.item_18.ForwardingSet;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BrokenObservableSet<E> extends ForwardingSet<E> {

    public static void main(String[] args) {

        // Deadlock example because another thread tries to access observers list,
        // which is currently locked by method notifyElementAdded
        BrokenObservableSet<Integer> thirdSet = new BrokenObservableSet<>(new HashSet<>());
        thirdSet.addObserver(new BrokenSetObserver<Integer>() {
            @Override
            public void added(BrokenObservableSet<Integer> currentSet, Integer element) {
                System.out.println(element);
                if (element == 23) {
                    ExecutorService exec = Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(() -> currentSet.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            thirdSet.add(i);
        }

        // this works
        BrokenObservableSet<Integer> set = new BrokenObservableSet<>(new HashSet<>());
        set.addObserver((s, e) -> System.out.println(e));

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }

        // this is broken with ConcurrentModificationException because
        // we try to remove current observer while the synchronized method
        // is iterating over the list of observers.
        BrokenObservableSet<Integer> anotherSet = new BrokenObservableSet<>(new HashSet<>());
        anotherSet.addObserver(new BrokenSetObserver<Integer>() {
            @Override
            public void added(BrokenObservableSet<Integer> currentSet, Integer element) {
                System.out.println(element);
                if (element == 23) {
                    currentSet.removeObserver(this);
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            anotherSet.add(i);
        }



    }

    public BrokenObservableSet(Set<E> set) {
        super(set);
    }

    private final List<BrokenSetObserver<E>> observers = new ArrayList<>();

    public void addObserver(BrokenSetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(BrokenSetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

    /**
     * Broken method to notify an observer. It invokes an alien
     * method of an observer from a synchronized region.
     */
    private void notifyElementAdded(E element) {
        synchronized (observers) {
            for (var observer : observers) {
                observer.added(this, element);
            }
        }
    }

    @Override
    public boolean add(E e) {
        boolean added = super.add(e);
        if (added) {
            notifyElementAdded(e);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) {
            result |= add(element); // Calls notifyElement
        }
        return result;
    }
}
