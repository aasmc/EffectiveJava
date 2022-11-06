package ru.aasmc.effectivejava.chapter_12.item_88;

import ru.aasmc.effectivejava.chapter_08.item_50.BrokenPeriod;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Date;

/**
 * Example of the immutable time period class that makes use of
 * defensive copy.
 */
public final class Period {
    private Date start;
    private Date end;

    public Period(Date start, Date end) {
        // defensive copy
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        // Validity check is performed on the internal objects and
        // not on the parameters.
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
    }

    public Date getStart() {
        // protection against mutation of internal state
        return new Date(start.getTime());
    }

    public Date getEnd() {
        // protection against mutation of internal state
        return new Date(end.getTime());
    }

    /**
     * Like a constructor, this method must not invoke any overridable method
     * either directly or indirectly.
     * @param s
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        // When an object is deserialized, it is critical to defensively copy any field
        // containing an object reference that a client must not posess.
        start = new Date(start.getTime());
        end = new Date(end.getTime());
        // check that our invariants are satisfied
        if (start.compareTo(end) > 0) {
            throw new InvalidObjectException(start + " after " + end);
        }
    }
}
