package ru.aasmc.effectivejava.chapter_02.item_04;

// Noninstantiable utility class
public class UtilityClass {
    // suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }
}
