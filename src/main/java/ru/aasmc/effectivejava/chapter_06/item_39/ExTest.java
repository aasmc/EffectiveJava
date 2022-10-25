package ru.aasmc.effectivejava.chapter_06.item_39;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExTestContainer.class)
public @interface ExTest {
    Class<? extends Exception> value();
}
