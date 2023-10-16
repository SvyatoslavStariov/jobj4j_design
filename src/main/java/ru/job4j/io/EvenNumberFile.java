package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data/even.txt")) {
            int read;
            StringBuilder stringBuilder = new StringBuilder();
            while ((read = in.read()) != -1) {
                stringBuilder.append((char) read);
            }
            String[] string = String.valueOf(stringBuilder).split("\\D");
            Arrays.stream(string)
                    .filter(str -> !str.isBlank())
                    .mapToInt(Integer::parseInt)
                    .forEach(result -> System.out.printf("Число %s - является четным: %s \n",
                            result, result % 2 == 0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}