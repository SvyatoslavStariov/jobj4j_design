package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Dir {
    public static void main(String[] args) throws IOException {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.printf("size : %s\n", file.getTotalSpace());
        for (File subfile : file.listFiles()) {
            Files.walkFileTree(Path.of(subfile.getAbsolutePath()), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                    System.out.printf("Длина файла %s, равна %d\n", path.getFileName(), Files.size(path));
                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }
}
