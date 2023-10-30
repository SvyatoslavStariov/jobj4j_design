package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileDuplicates {

    private static Map<FileProperty, List<Path>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Path.of("./"), new DuplicatesVisitor());
        map.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .forEach(entry -> {
                    FileProperty fileProperty = entry.getKey();
                    List<Path> paths = entry.getValue();
                    paths.forEach(path -> {
                        System.out.printf("This is file duplicate with name [%s] and size [%d] - absolute path %s \n",
                                fileProperty.getName(),
                                fileProperty.getSize(),
                                path.getFileName().toAbsolutePath());
                    });
                });
    }

    private static class DuplicatesVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            map.compute(new FileProperty(Files.size(file), file.getFileName().toString()), (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(file);
                return v;
            });
            return super.visitFile(file, attrs);
        }
    }
}
