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
            startAt = printErrorAndCount(answer, startAt);
        }
    }

    public static void printWordOrDigit(int startAt) {
        if (isMultipleThree(startAt) && isMultipleFive(startAt)) {
            System.out.println("FizzBuzz");
        } else if (isMultipleThree(startAt)) {
            System.out.println("Fizz");
        } else if (isMultipleFive(startAt)) {
            System.out.println("Buzz");
        } else {
            System.out.println(startAt);
        }
    }

    public static int printErrorAndCount(String answer, int startAt) {
        boolean error = isError(answer, startAt);
        if (error) {
            System.out.println("Ошибка. Начинай снова.");
        }
        return error ? 0 : startAt++;
    }

    private static boolean isError(String answer, int startAt) {
        boolean isMultiple = isMultipleThree(startAt) || isMultipleFive(startAt);
        return isMultiple || KEYWORDS.contains(answer) || !valueOf(startAt).equals(answer);
    }

    private static boolean isMultipleThree(int startAt) {
        return startAt % 3 == 0;
    }

    private static boolean isMultipleFive(int startAt) {
        return startAt % 5 == 0;
    }
}
