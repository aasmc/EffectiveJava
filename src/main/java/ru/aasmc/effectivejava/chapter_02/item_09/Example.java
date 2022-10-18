package ru.aasmc.effectivejava.chapter_02.item_09;

import java.io.*;

public class Example {
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // All exceptions, except the one that may be thrown by readLine()
            // are suppressed and can be accessed by calling Throwable.getSuppressed()
            // that was added in Java 7.
            return br.readLine();
        }
    }

    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
}
