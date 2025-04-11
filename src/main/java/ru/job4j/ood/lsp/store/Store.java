package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.store.model.Food;

import java.util.Date;
import java.util.List;

public interface Store {

    void saveFood(Food food, Date nowCalendar);

    void clearFoods();

    List<Food> getFoods();
}
