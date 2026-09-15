package com.dyed.name.sorter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author viraj
 */
public final class NameSorter {
    static final String OUTPUT_FILE = "sorted-names-list.txt";

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: name-sorter <file>");
            System.exit(1);
            return;
        }

        Path input = Path.of(args[0]);
        // check if the file is a regular file and exists
        if (!Files.isRegularFile(input)) {
            System.err.println("File not found: " + input);
            System.exit(1);
            return;
        }

        // sort the names by last name
        List<String> sorted = LastNameSorter.sort(NameFiles.read(input));
        // print the sorted names
        for (String name : sorted) {
            System.out.println(name);
        }
        // write the sorted names to the output file
        NameFiles.write(Path.of(OUTPUT_FILE), sorted);
    }
}
