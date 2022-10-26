package ru.aasmc.effectivejava.chapter_07.item_48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Example {
    /**
     * Example of a Stream pipeline that benefits from parallelization.
     *
     * Returns the number of primes less than or equal to n.
     */
    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }
}
