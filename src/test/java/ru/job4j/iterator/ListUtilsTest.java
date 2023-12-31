package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveWithFilter() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 5, 7, 8));
        Predicate<Integer> predicate = x -> x > 5;
        ListUtils.removeIf(list, predicate);
        assertThat(list).containsSequence(1, 4, 5);
    }

    @Test
    void whenReplaceWithFilter() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 5, 7, 8));
        Predicate<Integer> predicate = x -> x == 7;
        ListUtils.replaceIf(list, predicate, 9);
        assertThat(list).containsSequence(1, 4, 5, 9, 8);
    }

    @Test
    void whenRemoveAll() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 5, 7, 8));
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 4, 5));
        ListUtils.removeAll(list, elements);
        assertThat(list).containsSequence(7, 8);
    }
}