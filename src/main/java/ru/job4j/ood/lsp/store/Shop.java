package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.store.model.Food;

import java.util.function.Consumer;

public class Shop extends AbstractStore {

    @Override
    public boolean isIncludeRangePercent(int percent) {
        return percent >= 25 && percent < 100;
    }

    @Override
    protected Consumer<? super Food> specialDiscount(int percent) {
        Consumer<? super Food> specialCondition = food -> {
        };
        if (percent > 75) {
            specialCondition = food -> food.setDiscount((long) (food.getPrice() - (food.getPrice() * 0.20)));
        }
        return specialCondition;
    }
}
