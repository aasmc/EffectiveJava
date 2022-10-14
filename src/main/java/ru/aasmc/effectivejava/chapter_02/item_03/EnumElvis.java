package ru.aasmc.effectivejava.chapter_02.item_03;

/**
 * Provides serialization machinery for free.
 * Ironclad guarantee against multiple instantiation, even in the face of
 * sophisticated serialization or reflection attacks.
 */
public enum EnumElvis {
    INSTANCE;

    public void leaveTheBuilding() {}
}
