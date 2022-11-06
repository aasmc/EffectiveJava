package ru.aasmc.effectivejava.chapter_12.item_87;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A list of strings with a reasonable custom serialized form:
 * a number of strings and the strings themselves without
 * any implementation details.
 */
public final class StringList implements Serializable {
    private transient int size = 0;
    private transient Entry head = null;

    private static class Entry {
        String data;
        Entry next;
        Entry previous;
    }

    // Appends specified string to the list
    public final void add(String s) {
        // stub
    }

    /**
     * Serialize this {@code StringList} instance.
     *
     * @serialData The size of the list (the number of strings it contains)
     * is emitted ({@code int}), followed by all of its elements (each {@code String}),
     * in the proper sequence.
     */
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);
        // Write out all elements in the proper order
        for(Entry e = head; e != null; e = e.next) {
            s.writeObject(e.data);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        // Read all elements and insert them in the list
        for (int i = 0; i < numElements; i++) {
            add((String) s.readObject());
        }
    }

    // remainder omitted.
}





















