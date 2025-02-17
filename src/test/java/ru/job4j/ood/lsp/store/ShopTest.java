package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {

    @Test
    void whenMore25PercentIsIncludeRangePercent() {
        AbstractStore store = new Shop();
        Date createDate = new Date(2025, Calendar.FEBRUARY, 1);
        Date nowCalendar = new Date(2025, Calendar.FEBRUARY, 6);
        Date expiryDate = new Date(2025, Calendar.FEBRUARY, 21);
        int percent = store.percentWear(createDate, expiryDate, nowCalendar);
        boolean includeRangePercent = store.isIncludeRangePercent(percent);
        assertThat(percent).isGreaterThanOrEqualTo(25);
        assertThat(includeRangePercent).isTrue();
    }

    @Test
    void whenLess99PercentIsIncludeRangePercent() {
        AbstractStore store = new Shop();
        Date createDate = new Date(2025, Calendar.FEBRUARY, 1);
        Date nowCalendar = new Date(2025, Calendar.FEBRUARY, 29);
        Date expiryDate = new Date(2025, Calendar.FEBRUARY, 30);
        int percent = store.percentWear(createDate, expiryDate, nowCalendar);
        boolean includeRangePercent = store.isIncludeRangePercent(percent);
        assertThat(percent).isLessThan(99);
        assertThat(includeRangePercent).isTrue();
    }
}