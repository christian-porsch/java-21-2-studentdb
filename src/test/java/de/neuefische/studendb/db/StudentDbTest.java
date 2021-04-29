package de.neuefische.studendb.db;

import de.neuefische.studendb.model.BiologyStudent;
import de.neuefische.studendb.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentDbTest {

    private static Arguments[] provideTestAddArguments() {
        return new Arguments[]{
                Arguments.of(
                        new Student[]{
                                new BiologyStudent("Student 1", "1", "8","tweezers"),
                                new BiologyStudent("Student 2", "2", "7","tweezers")
                        },
                        new Student[]{
                                new BiologyStudent("Student 1", "1", "8","tweezers"),
                                new BiologyStudent("Student 2", "2", "7","tweezers"),
                                new BiologyStudent("Jane", "42", "8","tweezers")
                        }
                ),
                Arguments.of(
                        new Student[]{},
                        new Student[]{new BiologyStudent("Jane", "42", "8","tweezers")}
                )
        };
    }

    private static Arguments[] provideTestRemoveArguments() {
        return new Arguments[]{
                Arguments.of(
                        new Student[]{
                                new BiologyStudent("Hans", "12", "2","tweezers"),
                                new BiologyStudent("Jane", "42", "8","tweezers"),
                                new BiologyStudent("Peter", "23", "1","tweezers")
                        },
                        new Student[]{
                                new BiologyStudent("Hans", "12", "2","tweezers"),
                                new BiologyStudent("Peter", "23", "1","tweezers")
                        }
                ),
                Arguments.of(
                        new Student[]{
                                new BiologyStudent("Hans", "12", "2","tweezers"),
                                new BiologyStudent("Peter", "23", "1","tweezers")
                        },
                        new Student[]{
                                new BiologyStudent("Hans", "12", "2","tweezers"),
                                new BiologyStudent("Peter", "23", "1","tweezers")
                        }
                ),
                Arguments.of(
                        new Student[]{
                                new BiologyStudent("Jane", "42", "8","tweezers"),
                                new BiologyStudent("Hans", "12", "2","tweezers"),
                                new BiologyStudent("Peter", "23", "1","tweezers")
                        },
                        new Student[]{
                                new BiologyStudent("Hans", "12", "2","tweezers"),
                                new BiologyStudent("Peter", "23", "1","tweezers")
                        }
                ),
                Arguments.of(
                        new Student[]{
                                new BiologyStudent("Hans", "12", "2","tweezers"),
                                new BiologyStudent("Peter", "23", "1","tweezers"),
                                new BiologyStudent("Jane", "42", "8","tweezers")
                        },
                        new Student[]{
                                new BiologyStudent("Hans", "12", "2","tweezers"),
                                new BiologyStudent("Peter", "23", "1","tweezers")
                        }
                ),
                Arguments.of(
                        new Student[]{},
                        new Student[]{}
                ),
                Arguments.of(
                        new Student[]{new BiologyStudent("Jane", "42", "8","tweezers")},
                        new Student[]{}
                )
        };
    }

    @Test
    @DisplayName("list() returns all students in the db")
    public void testList() {
        // Given
        ArrayList<Student> students = new ArrayList<>(Arrays.asList
                (new BiologyStudent("Jane", "42", "8","tweezers"),
                new BiologyStudent("Klaus", "13", "3","tweezers"),
                new BiologyStudent("Franky", "100", "6","tweezers")));

        StudentDb studentDb = new StudentDb(students);

        // When
        ArrayList<Student> actual = studentDb.list();

        // Then
        Student[] expected = new Student[]{
                new BiologyStudent("Jane", "42", "8","tweezers"),
                new BiologyStudent("Klaus", "13", "3","tweezers"),
                new BiologyStudent("Franky", "100", "6","tweezers")
        };
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toString() returns a formatted list of all students")
    public void testToString() {
        // Given
        ArrayList<Student> students = new ArrayList<>(Arrays.asList
                (new BiologyStudent("Jane", "42", "8","tweezers"),
                new BiologyStudent("Klaus", "13", "3","tweezers"),
                new BiologyStudent("Franky", "100", "6","tweezers")));

        StudentDb studentDb = new StudentDb(students);

        // When
        String actual = studentDb.toString();

        // Then
        String expected = "Student{name='Jane', id='42'}\n"
                + "Student{name='Klaus', id='13'}\n"
                + "Student{name='Franky', id='100'}\n";
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideTestAddArguments")
    public void testAdd(ArrayList<Student> givenStudents, ArrayList<Student> expectedStudents) {
        // Given
        StudentDb studentDb = new StudentDb(givenStudents);
        studentDb.add(new BiologyStudent("Jane", "42", "8","tweezers"));

        // When

        ArrayList<Student> actualStudents = studentDb.list();

        // Then
        assertEquals(expectedStudents, actualStudents);
    }

    @ParameterizedTest
    @MethodSource("provideTestRemoveArguments")
    public void testRemove(ArrayList<Student> givenStudents, ArrayList<Student> expectedStudents) {
        // Given
        StudentDb studentDb = new StudentDb(givenStudents);

        // When
        studentDb.remove(new BiologyStudent("Jane", "42", "8","tweezers"));
        ArrayList<Student> actualStudents = studentDb.list();

        // Then
        assertEquals(expectedStudents, actualStudents);
    }

    @Test
    @DisplayName("testFindById() returns a student found by a specific id")
    public void testFindById() {
        // Given
        ArrayList<Student> students = new ArrayList<>(Arrays.asList
                (new BiologyStudent("Jane", "42", "8", "tweezers"),
                        new BiologyStudent("Klaus", "13", "3", "tweezers"),
                        new BiologyStudent("Franky", "100", "6", "tweezers")));

        StudentDb studentDb = new StudentDb(students);

        // When
        Student actual = studentDb.findById("13");

        // Then
        String expected = "Student{" + "name='Klaus', id='13'}\n";
        assertEquals(expected, actual);
    }
}