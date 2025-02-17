package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.store.model.Food;

import java.util.function.Consumer;

public class Trash extends AbstractStore {

    @Override
    public boolean isIncludeRangePercent(int percent) {
        return percent >= 100;
    }

    @Override
    protected Consumer<? super Food> specialDiscount(int percent) {
        return food -> {
        };
    }
}
