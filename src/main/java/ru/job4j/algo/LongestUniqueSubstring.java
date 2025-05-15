package ru.job4j.algo;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestUniqueSubstring {

    private static Set<Character> toSetString(String str) {
        return str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static String longestUniqueSubstring(String str) {
        String result = "";
        int j = 0;
        int i = 0;
        while (i <= str.length()) {
            String substring = str.substring(j, i);
            if (toSetString(substring).size() < substring.length()) {
                j = i - 1;
            } else if (substring.length() > result.length()) {
                result = substring;
            } else {
                i++;
            }
        }
        return result;
    }
}