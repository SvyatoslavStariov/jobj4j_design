package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.store.model.Food;

import java.util.Date;

public interface Store {

    void saveFood(Food food, Date nowCalendar);
}
