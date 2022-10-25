package ru.aasmc.effectivejava.chapter_06.item_39;

public class Sample {
    @Test
    public static void m1(){}// should pass


    public static void m2(){}

    @Test // should fail
    public static void m3(){
        throw new RuntimeException("Boom");
    }

    public static void m4(){}

    @Test
    public void m5(){} // invalid use case (non-static method)

    public static void m6(){}

    @Test
    public static void m7() { // should fail
        throw new RuntimeException("Crash");
    }

    public static void m8(){}

}
