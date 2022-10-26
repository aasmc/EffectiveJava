package ru.aasmc.effectivejava.chapter_07.item_45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardExample {
    private static List<Card> newDeckIterative() {
        List<Card> result = new ArrayList<>();
        for (var suit : Suit.values()) {
            for (var rank : Rank.values()) {
                result.add(new Card(suit, rank));
            }
        }
        return result;
    }

    private static List<Card> newDeckWithStream() {
        return Stream.of(Suit.values())
                .flatMap(suit ->
                        Stream.of(Rank.values())
                                .map(rank -> new Card(suit, rank))
                ).collect(Collectors.toList());
    }
}
