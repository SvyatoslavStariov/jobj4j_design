package ru.job4j.io.search;

import java.util.Arrays;

public enum TypeSearch {

    NONE("none"),

    MASK("mask"),

    NAME("name"),

    REGEX("regex");

    private String value;

    TypeSearch(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public static TypeSearch getValue(String typeSearch) {
        return Arrays.stream(TypeSearch.values())
                .filter(val -> val.getValue().equals(typeSearch))
                .findFirst()
                .orElse(TypeSearch.NONE);
    }
}
