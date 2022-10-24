package ru.aasmc.effectivejava.chapter_06.item_37;

import java.util.*;
import java.util.stream.Collectors;

public class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<LifeCycle, Set<Plant>>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }
        List<Plant> garden = List.of(new Plant("Rose", LifeCycle.ANNUAL), new Plant("Tulip", LifeCycle.ANNUAL));
        for (Plant plant : garden) {
            plantsByLifeCycle.get(plant.lifeCycle).add(plant);
        }
        System.out.println(plantsByLifeCycle);

        System.out.println("Stream example with EnumMap");
        var result = garden.stream()
                .collect(Collectors.groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(LifeCycle.class), Collectors.toSet()));
        System.out.println(result);
    }
}
