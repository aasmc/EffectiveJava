package ru.aasmc.effectivejava.chapter_02.item02;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    /**
     * Generic type with a recursive type parameter. This along with the
     * abstract self() method allows method chaining to work properly in subclasses
     * without the need for casts. This is called: "Simulated Self-Type" idiom.
     */
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        // covariant return typing.
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
