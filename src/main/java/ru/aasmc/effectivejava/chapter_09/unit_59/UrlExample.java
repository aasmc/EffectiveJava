package ru.aasmc.effectivejava.chapter_09.unit_59;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UrlExample {
    // Example of printing the contents of the contents of a URL
    // with transferTo method, added in Java 9
    public static void main(String[] args) throws IOException {
        try(InputStream in = new URL("https://www.jetbrains.com/ru-ru/education/").openStream()) {
            in.transferTo(System.out);
        }
    }
}
