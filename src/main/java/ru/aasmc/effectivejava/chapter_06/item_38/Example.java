package ru.aasmc.effectivejava.chapter_06.item_38;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        var random = new Random(System.currentTimeMillis());
        double x = random.nextDouble();
        double y = random.nextDouble();
        test(ExtendedOperation.class, y, x);
        System.out.println("****************************");
        testCollection(Arrays.asList(ExtendedOperation.values()), y, x);
    }

    private static <T extends Enum<T> & Operation> void test(
            Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    private static void testCollection(Collection<? extends Operation> opSet,
                                       double x, double y) {
        for(var op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
