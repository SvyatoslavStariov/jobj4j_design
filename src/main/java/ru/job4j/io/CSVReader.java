package ru.job4j.io;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CSVReader {
    private final static String PATH = "path";
    private final static String DELIMITER = "delimiter";
    private final static String FILTER = "filter";
    private final static String OUTPUT = "out";

    public static void handle(ArgsName argsName) {
        Map<Integer, String> filterMap = buildMapFilter(argsName);
        List<List<String>> readFile = readFile(argsName.get(PATH)).stream()
                .map(phrase -> Arrays.stream(phrase.split(argsName.get(DELIMITER)))
                        .collect(Collectors.toList()))
                .toList();
        Map<String, List<String>> rowColumnMap = buildRowAndColumn(readFile);
        String[][] result = sortMap(rowColumnMap, filterMap);
        writeFile(argsName.get(OUTPUT), buildResult(result, argsName));
    }

    private static String buildResult(String[][] result, ArgsName argsName) {
        return Arrays.stream(result)
                .map(str -> Arrays.stream(str)
                        .filter(Objects::nonNull)
                        .collect(Collectors.joining(argsName.get(DELIMITER))))
                .collect(Collectors.joining(System.lineSeparator()))
                .concat(System.lineSeparator());
    }

    private static String[][] sortMap(Map<String, List<String>> rowColumnMap,
                                      Map<Integer, String> filterMap) {
        Map<String, List<String>> sortedMap = new LinkedHashMap<>();
        int max = 0;
        for (Map.Entry<Integer, String> entry : filterMap.entrySet()) {
            List<String> strings = rowColumnMap.get(entry.getValue());
            if (!strings.isEmpty()) {
                max = Math.max(max, strings.size());
                sortedMap.put(entry.getValue(), strings);
            }
        }
        String[][] arr = new String[max + 1][max];
        int j = 0;
        for (Map.Entry<String, List<String>> stringListEntry : sortedMap.entrySet()) {
            int i = 0;
            arr[i++][j] = stringListEntry.getKey();
            for (String string : stringListEntry.getValue()) {
                arr[i++][j] = string;
            }
            j++;
        }
        return arr;
    }

    private static Map<String, List<String>> buildRowAndColumn(List<List<String>> readFile) {
        List<String> key = readFile.stream()
                .findFirst()
                .orElse(Collections.emptyList());
        return key.stream()
                .collect(Collectors.toMap(
                        k -> k,
                        k -> readFile.stream()
                                .skip(1)
                                .map(innerList -> innerList.get(key.indexOf(k)))
                                .collect(Collectors.toList())
                ));

    }

    private static Map<Integer, String> buildMapFilter(ArgsName argsName) {
        String[] array = argsName.get(FILTER).split(",");
        return IntStream.range(0, array.length)
                .boxed()
                .collect(Collectors.toMap(
                        index -> index,
                        index -> array[index],
                        (k, v) -> k,
                        LinkedHashMap::new
                ));
    }

    private static List<String> readFile(String path) {
        List<String> phrases = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(path))) {
            while (scanner.hasNextLine()) {
                phrases.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private static void writeFile(String string, String logs) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(string))) {
            bufferedWriter.write(logs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void isValid(ArgsName argsName) {
        Pattern patternDelimiter = Pattern.compile("[;,]");
        Pattern patternFilter = Pattern.compile("[,]");
        String path = argsName.get(PATH);
        String filter = argsName.get(FILTER);
        String delimiter = argsName.get(DELIMITER);
        String output = argsName.get(OUTPUT);
        if (!path.endsWith(".csv")) {
            throw new IllegalArgumentException(
                    String.format("Format path '%s' is wrong, but must .cvs", path)
            );
        }
        if (patternFilter.split(filter).length == 0) {
            throw new IllegalArgumentException(
                    String.format("Format filter '%s' is wrong", filter)
            );
        }
        if (!patternDelimiter.matcher(delimiter).matches()) {
            throw new IllegalArgumentException(
                    String.format("Format delimiter '%s' don't contains ';' or ','", delimiter)
            );
        }
        if (!output.endsWith(".csv")) {
            throw new IllegalArgumentException(
                    String.format("Format path '%s' is wrong, but must .cvs", output)
            );
        }
    }


    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        isValid(argsName);
        handle(argsName);
    }
}
