package ru.aasmc.effectivejava.chapter_02.item_05;

import java.util.function.Supplier;

public class Mosaic {
    // example of a user provided factory supplier
    Mosaic create(Supplier<? extends Tile> tileFactory) {
        // STUB
        return new Mosaic();
    }
}
