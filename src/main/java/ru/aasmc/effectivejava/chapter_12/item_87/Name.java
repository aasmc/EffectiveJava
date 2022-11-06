package ru.aasmc.effectivejava.chapter_12.item_87;

import java.io.Serializable;

/**
 * Good candidate for default serialized form
 */
public class Name implements Serializable {

    /**
     * Last name. Must be non-null.
     *
     * @serial
     */
    private final String lastName;
    /**
     * First name. Must be non-null.
     *
     * @serial
     */
    private final String firstName;
    /**
     * Middle name, or null if there's none.
     *
     * @serial
     */
    private final String middleName;

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
}
