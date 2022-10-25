package ru.aasmc.effectivejava.chapter_06.item_39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests3 {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(Sample2.class.getName());
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExTest.class) ||
                    m.isAnnotationPresent(ExTestContainer.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception:%n", m);
                } catch (InvocationTargetException wrappedEx) {
                    Throwable exc = wrappedEx.getCause();
                    int oldPassed = passed;
                    ExTest[] exTypes = m.getAnnotationsByType(ExTest.class);
                    for (var exType : exTypes) {
                        if (exType.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) {
                        System.out.printf("Test %s failed: %s%n", m, exc);
                    }
                } catch (Exception ex) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, tests - passed);
    }
}
