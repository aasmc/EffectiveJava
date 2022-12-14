package ru.aasmc.effectivejava.chapter_06.item_37;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Example of using a nested EnumMap to associate data with enum pairs.
 */
public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        // Initialize the phase transition map
        private static final Map<Phase, Map<Phase, Transition>> m =
                Stream.of(values()).collect(
                        Collectors.groupingBy(
                                t -> t.from,
                                () -> new EnumMap<>(Phase.class),
                                Collectors.toMap(
                                        t -> t.to,
                                        t -> t,
                                        (x, y) -> y, () -> new EnumMap<>(Phase.class)
                                )
                        )
                );

        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }
}
