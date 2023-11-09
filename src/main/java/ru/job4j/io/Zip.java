package ru.job4j.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private final static String DIRECTORY = "d";
    private final static String EXCLUDE = "e";
    private final static String OUTPUT = "o";

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void isValid(String directory, String exclude, String output) {
        if (!Files.isDirectory(Paths.get(directory))) {
            throw new IllegalArgumentException(String.format("arg '%s' isn't directory", directory));
        }
        if (!exclude.contains(".")) {
            throw new IllegalArgumentException(String.format("arg '%s' is exclude, don't contain '.'", exclude));
        }
        if (!output.endsWith(".zip")) {
            throw new IllegalArgumentException(String.format("arg output end %s, but must '.zip'", output));
        }
    }

    private List<Path> SearchFile(String directory, String exclude, String output) {
        isValid(directory, exclude, output);
        Path path = Path.of(directory);
        SearchFiles searchFiles = new SearchFiles(p -> {
            String name = p.toFile().getName();
            return !name.contains(exclude);
        });
        try {
            Files.walkFileTree(path, searchFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchFiles.getPaths();
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        Zip zip = new Zip();
        String directory = argsName.get(DIRECTORY);
        String exclude = argsName.get(EXCLUDE);
        String output = argsName.get(OUTPUT);
        List<Path> paths = zip.SearchFile(directory, exclude, output);
        zip.packFiles(
                paths,
                new File(output)
        );
    }
}