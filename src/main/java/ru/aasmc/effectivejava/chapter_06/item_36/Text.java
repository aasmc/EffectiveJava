package ru.aasmc.effectivejava.chapter_06.item_36;

import java.util.EnumSet;
import java.util.Set;

public class Text {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    /**
     * Any Set could be passed in, but EnumSet is clearly best.
     */
    public void applyStyles(Set<Style> styles) {
        // example method
    }

    public static void main(String[] args) {
        Text t = new Text();
        t.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
