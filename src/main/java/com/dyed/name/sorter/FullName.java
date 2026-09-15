package com.dyed.name.sorter;

import java.util.Arrays;

/**
 *
 * @author viraj
 */
public class FullName {
    final String lastName;
    final String givenNames;

    FullName(String lastName, String givenNames) {
        this.lastName = lastName;
        this.givenNames = givenNames;
    }

    // parse the line and return the FullName object
    public static FullName parse(String line) {
        String[] parts = line.trim().split("\\s+");
        // check if the number of parts is between 2 and 4
        if (parts.length < 2 || parts.length > 4) {
            throw new IllegalArgumentException(
                    "A name must have a last name along with 1 to 3 given names: \"" + line.trim() + "\"");
        }
        // get the last name
        String lastName = parts[parts.length - 1];
        // get the given names
        String givenNames = String.join(" ", Arrays.copyOf(parts, parts.length - 1));
        return new FullName(lastName, givenNames);
    }

    @Override
    public String toString() {
        return givenNames + " " + lastName;
    }
}
