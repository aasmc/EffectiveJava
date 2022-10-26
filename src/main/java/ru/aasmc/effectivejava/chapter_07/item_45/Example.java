package ru.aasmc.effectivejava.chapter_07.item_45;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Example {

    /**
     * Program that prints first 20 Mersenne prime numbers.
     * A Mersenne number is a number of the form (2^p) - 1.
     * If p is prime, then Mersenne number may be a prime.
     * If so, it's the Mersenne prime.
     * @param args
     */
    public static void main(String[] args) {
        primes().map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }
}
