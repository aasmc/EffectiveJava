package ru.aasmc.effectivejava.chapter_02.item_03;

public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {

    }

    // to preserve singleton property during serialization / deserialization
    private Object readResolve() {
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator
        return INSTANCE;
    }
}
