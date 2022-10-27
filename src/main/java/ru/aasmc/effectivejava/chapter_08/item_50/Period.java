package ru.aasmc.effectivejava.chapter_08.item_50;

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

    public static void main(String[] args) {
        var start = new Date();
        var end = new Date();
        var period = new BrokenPeriod(start, end);
        // ATTACK THE INTERNALS
        // exploits the fact that Date is mutable
        end.setYear(78);
    }
}
