package ru.aasmc.effectivejava.chapter_05.item_31;

import java.util.*;
import java.util.concurrent.ScheduledFuture;

public class Example {
    // Both of the arguments are producers, so we can make their type parameters
    // bounded
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    /**
     * Here [list] is the producer of elements, so we can use <? extends T>.
     * Comparable<T> consumes the element T, so we can declare it <? super T>.
     */
    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        if (list.isEmpty()) throw new IllegalArgumentException("Empty list");
        T result = null;
        for(T t: list) {
            if (result == null || t.compareTo(result) > 0) {
                result = Objects.requireNonNull(t);
            }
        }
        return result;
    }

    public static <T extends Comparable<T>> T maxWithoutBounds(List<T> list) {
        if (list.isEmpty()) throw new IllegalArgumentException("Empty list");
        T result = null;
        for(T t: list) {
            if (result == null || t.compareTo(result) > 0) {
                result = Objects.requireNonNull(t);
            }
        }
        return result;
    }

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        Set<Integer> integers = Set.of(1, 3, 5);
        Set<Double> doubles = Set.of(2.0, 4.0, 6.0);
        Set<Number> numbers = union(integers, doubles);
        System.out.println(numbers);

        List<ScheduledFuture<?>> scheduledFutures = Collections.emptyList();
        ScheduledFuture<?> max = max(scheduledFutures);
        // Does not compile since ScheduledFuture doesn't implement Comparable<ScheduledFuture>
        // instead it implements Delayed, which implements Comparable.
//        maxWithoutBounds(scheduledFutures);
    }
}






















