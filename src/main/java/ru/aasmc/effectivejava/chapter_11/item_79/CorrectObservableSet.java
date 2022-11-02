package ru.aasmc.effectivejava.chapter_11.item_79;

import ru.aasmc.effectivejava.chapter_04.item_18.ForwardingSet;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CorrectObservableSet<E> extends ForwardingSet<E> {

    public static void main(String[] args) {

        CorrectObservableSet<Integer> thirdSet = new CorrectObservableSet<>(new HashSet<>());
        thirdSet.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(CorrectObservableSet<Integer> currentSet, Integer element) {
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

        thirdSet.addObserverToCopyOnWriteArrayList(new SetObserver<Integer>() {
            @Override
            public void added(CorrectObservableSet<Integer> currentSet, Integer element) {
                System.out.println(element);
                if (element == 23) {
                    ExecutorService exec = Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(() -> currentSet.removeObserverFromCopyOnWriteList(this)).get();
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

        CorrectObservableSet<Integer> set = new CorrectObservableSet<>(new HashSet<>());
        set.addObserver((s, e) -> System.out.println(e));
        set.addObserverToCopyOnWriteArrayList((s, e) -> System.out.println(e));

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }

        CorrectObservableSet<Integer> anotherSet = new CorrectObservableSet<>(new HashSet<>());
        anotherSet.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(CorrectObservableSet<Integer> currentSet, Integer element) {
                System.out.println(element);
                if (element == 23) {
                    currentSet.removeObserver(this);
                }
            }
        });

        anotherSet.addObserverToCopyOnWriteArrayList(new SetObserver<Integer>() {
            @Override
            public void added(CorrectObservableSet<Integer> currentSet, Integer element) {
                System.out.println(element);
                if (element == 23) {
                    currentSet.removeObserverFromCopyOnWriteList(this);
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            anotherSet.add(i);
        }


    }

    public CorrectObservableSet(Set<E> set) {
        super(set);
    }

    private final List<SetObserver<E>> observers = new ArrayList<>();
    // another option that requires no explicit synchronization
    private final List<SetObserver<E>> anotherObservers = new CopyOnWriteArrayList<>();

    public void addObserverToCopyOnWriteArrayList(SetObserver<E> observer) {
        anotherObservers.add(observer);
    }

    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserverFromCopyOnWriteList(SetObserver<E> observer) {
        return anotherObservers.remove(observer);
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

    private void notifyElementAddedToCopyOnWriteList(E element) {
        for (var observer : anotherObservers) {
            observer.added(this, element);
        }
    }

    private void notifyElementAdded(E element) {
        List<SetObserver<E>> snapshot = null;
        synchronized (observers) {
            snapshot = new ArrayList<>(observers);
        }
        for (var observer : snapshot) {
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E e) {
        boolean added = super.add(e);
        if (added) {
            notifyElementAdded(e);
            notifyElementAddedToCopyOnWriteList(e);
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
