package ru.job4j.algo;

import java.util.Map;
import java.util.Stack;

public class Brackets {

    private static final Map<Character, Character> VALID_STRINGS = Map.of(
        '{', '}',
        '[', ']',
        '(', ')'
    );

    /**
     * Вычислительная сложность: O(n)
     * Пространственная сложность: O(n), из-за использования структуры Stack
     */
    public boolean isValid(String s) {
        boolean isValid = true;
        if (s == null || s.length() % 2 != 0) {
            isValid = false;
        } else {
            Stack<Character> leftParts = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '{' || c == '[' || c == '(') {
                    leftParts.push(c);
                } else if (c == '}' || c == ']' || c == ')') {
                    if (leftParts.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    if (VALID_STRINGS.get(leftParts.pop()) != c) {
                        isValid = false;
                        break;
                    }
                }
            }
        }
        return isValid;
    }
}
