package ru.aasmc.effectivejava.chapter_02.item_08;

import java.lang.ref.Cleaner;

/**
 * An AutoCloseable class using a cleaner as a safety net.
 */
public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    // Resource that requires cleaning. MUST NOT refer to Room!
    // Therefore we use static nested class, because nonstatic nested
    // classes contain references to their enclosing instances.
    private static class State implements Runnable {
        int numJunkPiles; // Number of junk piles in the room

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // Invoked by close method of cleaner
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    // The state of this room, shared with our cleanable
    private final State state;
    // Our cleanable. Cleans the room when it's eligible for gc.
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}


