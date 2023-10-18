package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        List<String> rsl = Collections.emptyList();
        try (BufferedReader in = new BufferedReader(new FileReader(this.file))) {
            rsl = in.lines()
                    .map(str -> str.split(" "))
                    .filter(strArr -> strArr.length >= 2)
                    .filter(strArr -> Objects.equals(strArr[strArr.length - 2], "404"))
                    .map(strArr -> String.join(" ", strArr))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.filter().forEach(System.out::println);
    }
}