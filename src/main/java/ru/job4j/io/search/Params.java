package ru.job4j.io.search;

public enum Params {

    DIRECTORY("d"),

    FILE_NAME_REGEX("n"),

    TYPE_SEARCH("t"),

    OUTPUT("o");

    private String value;

    Params(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
