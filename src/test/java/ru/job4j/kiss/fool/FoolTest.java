package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoolTest {

    @Test
    void whenPrintFizzBuzzDigitMultipleThreeAndFive() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.printWordOrDigit(15);
        assertEquals("FizzBuzz" + System.lineSeparator(), out.toString());
    }

    @Test
    void whenPrintBuzzDigitMultipleFive() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.printWordOrDigit(10);
        assertEquals("Buzz" + System.lineSeparator(), out.toString());
    }


    @Test
    void whenPrintDigitIsNotMultiple() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.printWordOrDigit(2);
        assertEquals("2" + System.lineSeparator(), out.toString());
    }

    @Test
    void whenPrintErrorDigitMultipleThree() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.isAnswerError("", 3);
        assertEquals("Ошибка. Начинай снова." + System.lineSeparator(), out.toString());
    }

    @Test
    void whenPrintErrorDigitMultipleFive() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.isAnswerError("", 5);
        assertEquals("Ошибка. Начинай снова." + System.lineSeparator(), out.toString());
    }

    @Test
    void whenPrintErrorDigitMultipleThreeAndFive() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.isAnswerError("", 15);
        assertEquals("Ошибка. Начинай снова." + System.lineSeparator(), out.toString());
    }

    @Test
    void whenPrintErrorWrongWordFizzBuzz() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.isAnswerError("FizzBuzz", 0);
        assertEquals("Ошибка. Начинай снова." + System.lineSeparator(), out.toString());
    }

    @Test
    void whenPrintErrorWrongWordBuzz() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.isAnswerError("Buzz", 0);
        assertEquals("Ошибка. Начинай снова." + System.lineSeparator(), out.toString());
    }

    @Test
    void whenPrintErrorWrongWordFizz() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.isAnswerError("Fizz", 0);
        assertEquals("Ошибка. Начинай снова." + System.lineSeparator(), out.toString());
    }
}