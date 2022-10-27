package ru.aasmc.effectivejava.chapter_08.item_50;

import java.util.Date;

/**
 * Example of a broken immutable time period class.
 */
public final class BrokenPeriod {
    private final Date start;
    private final Date end;

    public BrokenPeriod(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
        this.start = start;
        this.end = end;
    }

    // also possible to mutate the internals by mutating the value returned by the method
    public Date getStart() {
        return start;
    }

    // also possible to mutate the internals by mutating the value returned by the method
    public Date getEnd() {
        return end;
    }

    public static void main(String[] args) {
        var start = new Date();
        var end = new Date();
        var period = new BrokenPeriod(start, end);
        // ATTACK THE INTERNALS
        // exploits the fact that Date is mutable
        end.setYear(78);
    }
}
