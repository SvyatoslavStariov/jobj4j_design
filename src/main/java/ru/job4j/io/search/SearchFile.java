package ru.job4j.io.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.ArgsName;
import ru.job4j.io.SearchFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static ru.job4j.io.search.Params.DIRECTORY;
import static ru.job4j.io.search.Params.FILE_NAME_REGEX;
import static ru.job4j.io.search.Params.OUTPUT;
import static ru.job4j.io.search.Params.TYPE_SEARCH;
import static ru.job4j.io.search.Validator.isValid;

public class SearchFile {

    private static final Logger LOG = LoggerFactory.getLogger(SearchFile.class.getName());

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        handler(argsName);
    }

    private static void handler(ArgsName argsName) {
        isValid(argsName);
        List<Path> resultSearch = readFile(argsName);
        String data = getData(resultSearch);
        writeFile(data, argsName.get(OUTPUT.getValue()));
    }

    private static List<Path> readFile(ArgsName argsName) {
        return searchFile(argsName.get(DIRECTORY.getValue()), argsName.get(FILE_NAME_REGEX.getValue()),
                TypeSearch.getValue(argsName.get(TYPE_SEARCH.getValue())));
    }

    private static List<Path> searchFile(String directory, String fileNameRegex, TypeSearch typeSearch) {
        Path path = Path.of(directory);
        SearchFiles searchFiles = new SearchFiles(p -> isFileFind(p, fileNameRegex, typeSearch));
        try {
            Files.walkFileTree(path, searchFiles);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return searchFiles.getPaths();
    }

    private static String getData(List<Path> paths) {
        return paths.stream()
                .map(Path::toAbsolutePath)
                .map(Path::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static boolean isFileFind(Path path, String fileNameRegex, TypeSearch typeSearch) {
        if (typeSearch == TypeSearch.REGEX) {
            return FileSystems.getDefault().getPathMatcher("regex:" + fileNameRegex).matches(path.getFileName());
        }
        if (typeSearch == TypeSearch.NAME || typeSearch == TypeSearch.MASK) {
            return FileSystems.getDefault().getPathMatcher("glob:" + fileNameRegex).matches(path.getFileName());
        }
        throw new IllegalArgumentException("Type for search don't find: " + typeSearch);
    }

    private static void writeFile(String rls, String target) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(target))) {
            bufferedWriter.write(rls);
        } catch (IOException e) {
            LOG.error("Error write result to file with name '{}'", target);
            e.printStackTrace();
        }
    }
}
