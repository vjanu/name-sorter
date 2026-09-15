package com.dyed.name.sorter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author viraj
 */
class FileCheckTest {

    @Test
    // test if the file does not exist
    void testFileDoesNotExist(@TempDir Path dir) {
        Path missing = dir.resolve("unsorted-names-list.txt");
        assertFalse(Files.isRegularFile(missing));
    }

    @Test
    // test if the file exists
    void testFileExists(@TempDir Path dir) throws Exception {
        Path file = dir.resolve("unsorted-names-list.txt");
        Files.writeString(file, "Janet Parsons\n");
        assertTrue(Files.isRegularFile(file));
    }

    @Test
    // test if the file can be written and read
    void testWriteAndRead(@TempDir Path dir) throws Exception {
        Path file = dir.resolve("sample-names.txt");
        List<String> lines = List.of("Janet Parsons", "Marin Alvarez");
        NameFiles.write(file, lines);
        assertEquals(lines, NameFiles.read(file));
    }
}
