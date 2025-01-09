package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoolTest {

    @Test
    void when_print_fizz_buzz_digit_multiple_three_and_five() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.printWordOrDigit(15);
        assertEquals("FizzBuzz" + System.lineSeparator(), out.toString());
    }

    @Test
    void when_print_buzz_digit_multiple_five() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.printWordOrDigit(10);
        assertEquals("Buzz" + System.lineSeparator(), out.toString());
    }


    @Test
    void when_print_digit_not_multiple() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.printWordOrDigit(2);
        assertEquals("2" + System.lineSeparator(), out.toString());
    }

    @Test
    void when_print_error_digit_multiple_three() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.isAnswerError("", 3);
        assertEquals("Ошибка. Начинай снова." + System.lineSeparator(), out.toString());
    }

    @Test
    void when_print_error_digit_multiple_five() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.isAnswerError("", 5);
        assertEquals("Ошибка. Начинай снова." + System.lineSeparator(), out.toString());
    }

    @Test
    void when_print_error_digit_multiple_three_and_five() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.isAnswerError("", 15);
        assertEquals("Ошибка. Начинай снова." + System.lineSeparator(), out.toString());
    }

    @Test
    void when_print_error_wrong_word_fizz_buzz() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.isAnswerError("FizzBuzz", 0);
        assertEquals("Ошибка. Начинай снова." + System.lineSeparator(), out.toString());
    }

    @Test
    void when_print_error_wrong_word_buzz() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.isAnswerError("Buzz", 0);
        assertEquals("Ошибка. Начинай снова." + System.lineSeparator(), out.toString());
    }

    @Test
    void when_print_error_wrong_word_fizz() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Fool.isAnswerError("Fizz", 0);
        assertEquals("Ошибка. Начинай снова." + System.lineSeparator(), out.toString());
    }
}