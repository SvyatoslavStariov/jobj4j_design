package ru.job4j.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericsTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testPrintObject() {
        Generics generics = new Generics();
        List<Animal> first = List.of(new Animal());
        List<Predator> second = List.of(new Predator());
        List<Tiger> third = List.of(new Tiger());

        String expected = "Текущий элемент: class ru.job4j.generics.Animal"
                + System.lineSeparator()
                + "Текущий элемент: class ru.job4j.generics.Predator"
                + System.lineSeparator()
                + "Текущий элемент: class ru.job4j.generics.Tiger";
        generics.printObject(first);
        generics.printObject(second);
        generics.printObject(third);
        assertEquals(expected, outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void testPrintBoundedWildCard() {
        Generics generics = new Generics();
        List<Predator> second = List.of(new Predator());
        List<Tiger> third = List.of(new Tiger());

        String expected = "Текущий элемент: class ru.job4j.generics.Predator"
                + System.lineSeparator()
                + "Текущий элемент: class ru.job4j.generics.Tiger";
        generics.printBoundedWildCard(second);
        generics.printBoundedWildCard(third);
        assertEquals(expected, outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void testPrintLowerBoundedWildCard() {
        Generics generics = new Generics();
        List<Animal> first = List.of(new Animal());
        List<Predator> second = List.of(new Predator());

        String expected = "Текущий элемент: class ru.job4j.generics.Animal"
                + System.lineSeparator()
                + "Текущий элемент: class ru.job4j.generics.Predator";
        generics.printLowerBoundedWildCard(first);
        generics.printLowerBoundedWildCard(second);
        assertEquals(expected, outputStreamCaptor.toString()
                .trim());
    }
}