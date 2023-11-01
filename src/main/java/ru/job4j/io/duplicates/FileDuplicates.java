package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class FileDuplicates {

    public static void main(String[] args) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), duplicatesVisitor);
        printFile(duplicatesVisitor.getFilePathtMap());
    }

    private static void printFile(Map<FileProperty, List<Path>> filePathtMap) {
        if (filePathtMap.isEmpty()) {
            return;
        }
        filePathtMap.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .forEach(entry -> {
                    FileProperty fileProperty = entry.getKey();
                    List<Path> paths = entry.getValue();
                    paths.forEach(path -> {
                        System.out.printf("This is file duplicate with name [%s] and size [%d] - absolute path %s \n",
                                fileProperty.getName(),
                                fileProperty.getSize(),
                                path.toString());
                    });
                });
    }
}
