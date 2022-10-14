package ru.aasmc.effectivejava.chapter_02.item_06;

import java.util.regex.Pattern;

public class Example {
    /**
     * While String.matches is the easiest way to check if a string matches
     * a regular expression, it's not suitable for repeated use in performance critical situations.
     * The problem is, that it internally creates a Pattern instance every time it is invoked.
     */
    static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" +
                "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" +
            "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralEfficient(String s) {
        return ROMAN.matcher(s).matches();
    }
}
