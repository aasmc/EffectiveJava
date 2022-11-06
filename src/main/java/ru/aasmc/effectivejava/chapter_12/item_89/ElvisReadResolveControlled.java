package ru.aasmc.effectivejava.chapter_12.item_89;

import java.io.Serial;
import java.io.Serializable;

/**
 * A class that represents a singleton that depends on readResolve for
 * instance control.
 *
 * All instance fields with object reference types MUST be declared
 * transient.
 */
public class ElvisReadResolveControlled implements Serializable {
    public static final ElvisReadResolveControlled INSTANCE = new ElvisReadResolveControlled();
    private ElvisReadResolveControlled(){}

    public void leaveTheBuilding(){}

    @Serial
    private Object readResolve() {
        // return the singleton instance, and let the GC handle
        // the instance returned by the readObject method.
        return INSTANCE;
    }
}
