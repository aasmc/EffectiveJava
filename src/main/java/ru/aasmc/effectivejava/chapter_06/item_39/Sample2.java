package ru.aasmc.effectivejava.chapter_06.item_39;

public class Sample2 {
    @ExceptionTest({ArithmeticException.class, NullPointerException.class})
    public static void m1() { // should pass
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() { // should fail
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {
    } // should fail - no exception

    @ExTest(NullPointerException.class)
    @ExTest(IndexOutOfBoundsException.class)
    public static void doubleBad() {
        Integer i = null;
        i = i / i;
        throw new IndexOutOfBoundsException();
    }
}
