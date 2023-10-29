package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchFiles extends SimpleFileVisitor<Path> {
    private List<Path> paths = new ArrayList<>();
    private Predicate<Path> predicate;

    public SearchFiles(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    public List<Path> getPaths() {
        return paths.stream()
                .filter(Objects::nonNull)
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        paths.add(file.getFileName());
        return super.visitFile(file, attrs);
    }
}
