package com.dyed.name.sorter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author viraj
 */
class FullNameTest {

    @Test
    // test if the names are sorted by last name
    void testSortByLastName() {
        List<String> sorted = LastNameSorter.sort(List.of(
                "Janet Parsons",
                "Vaughn Lewis",
                "Adonis Julius Archer",
                "Shelby Nathan Yoder",
                "Marin Alvarez",
                "London Lindsey",
                "Beau Tristan Bentley",
                "Leo Gardner",
                "Hunter Uriah Mathew Clarke",
                "Mikayla Lopez",
                "Frankie Conner Ritter"));

        assertEquals(List.of(
                "Marin Alvarez",
                "Adonis Julius Archer",
                "Beau Tristan Bentley",
                "Hunter Uriah Mathew Clarke",
                "Leo Gardner",
                "Vaughn Lewis",
                "London Lindsey",
                "Mikayla Lopez",
                "Janet Parsons",
                "Frankie Conner Ritter",
                "Shelby Nathan Yoder"), sorted);
    }

    @Test
    // test if the names with the same last name are sorted by given names
    void testSameLastName() {
        assertEquals(
                List.of("John Lopez", "Mike Lopez"),
                LastNameSorter.sort(List.of("John Lopez", "Mike Lopez")));
    }

    @Test
    // test if the name is parsed correctly
    void testParseName() {
        FullName name = FullName.parse("Michael Jordan Thomas");
        assertEquals("Thomas", name.lastName);
        assertEquals("Michael Jordan", name.givenNames);
        assertEquals("Michael Jordan Thomas", name.toString());
    }

    @Test
    // test if the invalid name is parsed correctly
    void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> FullName.parse("Yerrelly"));
        assertThrows(IllegalArgumentException.class, () -> FullName.parse("Viraj Wick Shaun Diaz Extra"));
    }
}
