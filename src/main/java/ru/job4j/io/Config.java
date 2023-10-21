package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    public final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
            String str;
            int numberStr = 1;
            while ((str = in.readLine()) != null) {
                int separator = str.indexOf("=");
                if (separator != -1 && str.charAt(0) != '#') {
                    String key = str.substring(0, separator);
                    String value = str.substring(separator + 1);
                    valid(key, value, numberStr);
                    values.put(key, value);
                }
                numberStr++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void valid(String key, String value, int number) {
        if (key.isBlank() && value.isBlank()) {
            throw new IllegalArgumentException(String.format("wrong pattern, key and value is blank, on line %s", number));
        }
        if (key.isBlank()) {
            throw new IllegalArgumentException(String.format("wrong pattern, value '%s' without key, on line %s", value, number));
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException(String.format("wrong pattern, key '%s' without value, on line %s", key, number));
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("data/app.properties");
        config.load();
    }

}