package ru.aasmc.effectivejava.chapter_12.item_89;

import ru.aasmc.effectivejava.chapter_02.item_03.Elvis;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

public class ElvisBroken implements Serializable {
    public static final ElvisBroken INSTANCE = new ElvisBroken();

    private ElvisBroken() {
    }

    // WRONG. need to be transient
    private String[] favouriteSongs = {"Hound Dog", "Heartbreak hotel"};

    public void printFavourites() {
        System.out.println(Arrays.toString(favouriteSongs));
    }

    @Serial
    private Object readResolve() {
        return INSTANCE;
    }
}
