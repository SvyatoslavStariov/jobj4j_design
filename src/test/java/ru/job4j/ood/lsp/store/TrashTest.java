package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

class TrashTest {

    @Test
    void whenMore100PercentIsIncludeRangePercent() {
        AbstractStore store = new Trash();
        Date createDate = new Date(2025, Calendar.FEBRUARY, 1);
        Date nowCalendar = new Date(2025, Calendar.FEBRUARY, 21);
        Date expiryDate = new Date(2025, Calendar.FEBRUARY, 20);
        int percent = store.percentWear(createDate, expiryDate, nowCalendar);
        boolean includeRangePercent = store.isIncludeRangePercent(percent);
        assertThat(percent).isGreaterThan(100);
        assertThat(includeRangePercent).isTrue();
    }
}