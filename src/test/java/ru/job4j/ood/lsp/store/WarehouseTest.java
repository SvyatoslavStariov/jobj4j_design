package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {

    @Test
    void whenLess25PercentIsIncludeRangePercent() {
        AbstractStore store = new Warehouse();
        Date createDate = new Date(2025, Calendar.FEBRUARY, 1);
        Date nowCalendar = new Date(2025, Calendar.FEBRUARY, 6);
        Date expiryDate = new Date(2025, Calendar.FEBRUARY, 25);
        int percent = store.percentWear(createDate, expiryDate, nowCalendar);
        boolean includeRangePercent = store.isIncludeRangePercent(percent);
        assertThat(percent).isLessThan(24);
        assertThat(includeRangePercent).isTrue();
    }
}