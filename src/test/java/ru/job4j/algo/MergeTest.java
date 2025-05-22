package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTest {

    @Test
    void whenSortedThenOk() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenSortedThenOk2() {
        int[] array = {3, 8, 1, 6, 4, 2, 7, 5};
        assertThat(Merge.mergesort(array)).containsExactly(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    void whenInputArrayEmptyThenSortedEmpty() {
        int[] array = new int[]{};
        assertThat(Merge.mergesort(array)).isEqualTo(array);
    }
}