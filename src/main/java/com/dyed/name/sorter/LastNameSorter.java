package com.dyed.name.sorter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author viraj
 */
public class LastNameSorter {
    // sort the list of lines by last name
    public static List<String> sort(List<String> lines) {
        List<FullName> names = new ArrayList<>();
        // parse the lines and add the FullName objts to the list
        for (String line : lines) {
            names.add(FullName.parse(line));
        }
        // sort the list of FullName  by last name
        names.sort(LastNameSorter::compare);

        List<String> sorted = new ArrayList<>();
        // add the FullName objts to the sorted list
        for (FullName name : names) {
            sorted.add(name.toString());
        }
        return sorted;
    }

    private static int compare(FullName a, FullName b) {
        int last = a.lastName.compareTo(b.lastName);
        // if the last name is not the same, return the comparison of the last names
        if (last != 0) {
            return last;
        }
        return a.givenNames.compareTo(b.givenNames);
    }
}
