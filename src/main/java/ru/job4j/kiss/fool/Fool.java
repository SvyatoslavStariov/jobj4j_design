package ru.job4j.kiss.fool;

import java.util.Scanner;
import java.util.Set;

import static java.lang.String.valueOf;

public class Fool {

    private final static Set<String> KEYWORDS = Set.of("FizzBuzz", "Fizz", "Buzz");

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        int startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            printWordOrDigit(startAt++);
            var answer = input.nextLine();
            startAt = isAnswerError(answer, startAt) ? 0 : startAt + 1;
        }
    }

    public static void printWordOrDigit(int startAt) {
        boolean isMultipleThree = startAt % 3 == 0;
        boolean isMultipleFive = startAt % 5 == 0;
        if (isMultipleThree && isMultipleFive) {
            System.out.println("FizzBuzz");
            return;
        }
        if (isMultipleThree) {
            System.out.println("Fizz");
            return;
        }
        if (isMultipleFive) {
            System.out.println("Buzz");
            return;
        }
        System.out.println(startAt);
    }

    public static boolean isAnswerError(String answer, int startAt) {
        boolean isMultiple = startAt % 3 == 0 || startAt % 5 == 0;
        boolean isError = isMultiple || KEYWORDS.contains(answer) || !valueOf(startAt).equals(answer);
        if (isError) {
            System.out.println("Ошибка. Начинай снова.");
        }
        return isError;
    }
}
