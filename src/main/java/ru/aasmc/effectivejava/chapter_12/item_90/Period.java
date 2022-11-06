package ru.aasmc.effectivejava.chapter_12.item_90;

import java.io.*;
import java.util.Date;

/**
 * Example of the immutable time period class that makes use of
 * defensive copy.
 */
public final class Period {
    private final Date start;
    private final Date end;

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

    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        SerializationProxy(Period p) {
            this.start = p.start;
            this.end = p.end;
        }

        @Serial
        private Object readResolve() {
            return new Period(start, end);
        }

        private static final long serialVersionUID = 1333777484773899930L; // Any number will do
    }

    /**
     * The presence of this method on the enclosing class causes the serialization system
     * to emit a SerializationProxy instance instead of an instance of the enclosing
     * class prior to serialization. The serialization system will never generate
     * a serialized instance of the enclosing class. But an attacker might fabricate
     * one in an attempt to violate class invariants. To prevent this, you need to add readObject
     */
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    private void readObject(ObjectInputStream s) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }
}
