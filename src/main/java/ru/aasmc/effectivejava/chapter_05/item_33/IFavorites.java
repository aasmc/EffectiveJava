package ru.aasmc.effectivejava.chapter_05.item_33;

public interface IFavorites {
    <T> void putFavorite(Class<T> type, T instance);

    <T> T getFavorite(Class<T> type);
}
