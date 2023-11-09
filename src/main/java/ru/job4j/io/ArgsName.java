package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String value = values.get(key);
        isValidValue(value, key);
        return value;
    }

    private void parse(String[] args) {
        for (String arg : args) {
            int indexSplit = arg.indexOf("=");
            String key = arg.substring(1, indexSplit);
            String value = arg.substring(indexSplit + 1);
            values.put(key, value);
        }
    }

    public static ArgsName of(String[] args) {
        isValid(args);
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void isValid(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        for (String arg : args) {
            int indexSplit = arg.indexOf("=");
            if (indexSplit == -1) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain an equal sign", arg));
            }
            String key = arg.substring(0, indexSplit);
            String value = arg.substring(indexSplit + 1);
            isValidValue(value, arg);
            isValidKey(key, arg);
        }
    }

    private static void isValidValue(String value, String arg) {
        if (value == null) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", arg));
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a value", arg));
        }
    }

    private static void isValidKey(String key, String arg) {
        if (key.length() < 2) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a key", arg));
        }
        if (!key.startsWith("-")) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not start with a '-' character", arg));
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}