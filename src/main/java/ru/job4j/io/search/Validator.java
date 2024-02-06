package ru.job4j.io.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.ArgsName;

import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.job4j.io.search.Params.DIRECTORY;
import static ru.job4j.io.search.Params.OUTPUT;
import static ru.job4j.io.search.Params.TYPE_SEARCH;

public class Validator {

    private static final Logger LOG = LoggerFactory.getLogger(SearchFile.class.getName());

    public static void isValid(ArgsName argsName) {
        String directory = argsName.get(DIRECTORY.getValue());
        String output = argsName.get(OUTPUT.getValue());
        TypeSearch typeSearch = TypeSearch.getValue(argsName.get(TYPE_SEARCH.getValue()));
        isValidDirectory((directory));
        isValidTypeSearch(typeSearch);
        isValidOuPutFile(output);
    }

    private static void isValidDirectory(String directory) {
        if (!Files.isDirectory(Paths.get(directory))) {
            String errorMessage = String.format("arg '%s' isn't directory", directory);
            LOG.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void isValidTypeSearch(TypeSearch typeSearch) {
        if (TypeSearch.NONE == typeSearch) {
            String errorMessage = "type search don't find";
            LOG.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void isValidOuPutFile(String output) {
        if (!output.endsWith(".txt")) {
            String errorMessage = String.format("format of file %s don't support", output);
            LOG.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
