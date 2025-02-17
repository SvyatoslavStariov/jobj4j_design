package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.store.model.Food;

import java.util.function.Consumer;

public class Warehouse extends AbstractStore {

    @Override
    public boolean isIncludeRangePercent(int percent) {
        return 25 > percent;
    }

    @Override
    protected Consumer<? super Food> specialDiscount(int percent) {
        return food -> {
        };
    }
}
