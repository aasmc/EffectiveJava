package ru.aasmc.effectivejava.chapter_07.item_47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Example {
    // Adapter from Stream<E> to Iterable<E>
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    public static void main(String[] args) {
        for (ProcessHandle p : iterableOf(ProcessHandle.allProcesses())) {
            // process p
        }
    }

    // Adapter from Iterable<E> to Stream<E>
    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
