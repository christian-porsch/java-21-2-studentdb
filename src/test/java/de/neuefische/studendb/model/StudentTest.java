package de.neuefische.studendb.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("A students name can be set")
    public void testSetAndGetName(){
        // Given
        Student student = new BiologyStudent("Jane Doe", "42", "8","tweezers");

        // When
        student.setName("John Doe");
        String actual = student.getName();

        // Then
        assertEquals("John Doe", actual);
    }

    @Test
    @DisplayName("A students id can be set")
    public void setAndGetId(){
        // Given
        Student student = new BiologyStudent("Jane Doe", "42", "8","tweezers");

        // When
        student.setId("113");
        String actual = student.getId();

        // Then
        assertEquals("113", actual);
    }

    @ParameterizedTest(name = "equals() of {0} and {1} is {2}")
    @MethodSource("provideTestEqualsArguments")
    public void testEquals(Student studentA, Student studentB, boolean expected){
        // When
        boolean actual = studentA.equals(studentB);

        // Then
        assertEquals(expected, actual);
    }

    private static Arguments[] provideTestEqualsArguments(){
        return new Arguments[]{
            Arguments.of(new BiologyStudent("Jane Doe", "42", "8","tweezers"), new BiologyStudent("Jane Doe", "42", "8","tweezers"), true),
            Arguments.of(new BiologyStudent("Jane Doe", "42", "8","tweezers"), new BiologyStudent("John","42", "5","Observation glas"), false),
        };
    }

    @Test
    @DisplayName("toString() returns a formatted student")
    public void testToString(){
        // Given
        Student student = new BiologyStudent("Jane Doe", "42", "8","tweezers");

        // When
        String actual = student.toString();

        // Then
        String expected = "Student{name='Jane', id='42'}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Students with same name and id have the same hash code")
    public void testHashCode(){
        // Given
        Student studentA = new BiologyStudent("Jane Doe", "42", "8","tweezers");
        Student studentB = new BiologyStudent("Jane Doe", "42", "8","tweezers");

        // When
        boolean actual = studentA.hashCode() == studentB.hashCode();

        // Then
        assertTrue(actual);
    }
}
