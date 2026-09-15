package com.dyed.name.sorter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author viraj
 */
public class NameFiles {
    // read the file and return the list of lines
    public static List<String> read(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    // write the list of lines to the file
    public static void write(Path path, List<String> lines) throws IOException {
        Files.write(path, lines);
    }
}
