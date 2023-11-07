package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        isValid(args);
        String path = args[0];
        String fileFormat = args[1];
        Path start = Paths.get(path);
        search(start, p -> p.toFile().getName().endsWith(fileFormat)).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void isValid(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("No arguments");
        }
        if (!Files.exists(Paths.get(args[0])) && !Files.isDirectory(Paths.get(args[0]))) {
            throw new IllegalArgumentException(String.format("Wrong path from patter [%s]", args[0]));
        }
        if (!args[1].matches("^\\.[^0-9]+")) {
            throw new IllegalArgumentException(String.format("Wrong patter [%s] for file format", args[1]));
        }
    }
}