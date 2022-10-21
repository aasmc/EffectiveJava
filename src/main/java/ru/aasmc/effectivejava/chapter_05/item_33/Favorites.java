package ru.aasmc.effectivejava.chapter_05.item_33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Typesafe heterogeneous container pattern implementation.
 * All keys are of different types.
 *
 * Limitation. It cannot be used on a non-reifiable type. You CAN store your favorite
 * String or String[], but you can't store List<String>.
 */
public class Favorites implements IFavorites{
    // NB. Pay attention to Class<?> key.
    private Map<Class<?>, Object> favorites = new HashMap<>();

    @Override
    public <T> void putFavorite(Class<T> type, T instance) {
        // achieving runtime type safety with a dynamic cast type.cast(instance)
        // to prevent a malicious client of Favorites to pass a raw Class and some other instance
        // as parameters. E.g. putFavorite(Class class, String instance)
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    @Override
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
