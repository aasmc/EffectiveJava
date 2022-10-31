package ru.aasmc.effectivejava.chapter_09.unit_59;

import java.util.Random;

public class FlawedExample {
    static Random rnd = new Random();

    /**
     * The method looks good, but it has three flaws. The first is that if
     * [n] is a small power of two, the sequence of random numbers will repeat itself
     * after a fairly short period. The second flaw is that if [n] is not a power of two,
     * some numbers will, on average, be returned more frequently than others, as demonstrated
     * in the main example method.
     * Third flaw is that it can, or rare occasions, fail catastrophically, returning a number outside
     * the specified range. This is so because the method attempts to map the value
     * returned by rnd.nextInt() to a non-negative int by calling Math.abs. If nextInt() returns
     * Integer.MIN_VALUE, Math.abs will also return Integer.MIN_VALUE, and the remainder operator (%)
     * will return a negative number, assuming n is not a power of two.
     */
    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; ++i) {
            if (random(n) < n / 2) {
                ++low;
            }
        }
        System.out.println(low);
    }

}
