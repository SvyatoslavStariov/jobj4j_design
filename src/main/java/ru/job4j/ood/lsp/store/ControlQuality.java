package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.store.model.Food;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControlQuality {

    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void distributionProduct(Food food, Date nowCalendar) {
        stores.forEach(store -> store.saveFood(food, nowCalendar));
    }

    public void resort(Date nowCalendar) {
        List<Food> foods = new ArrayList<>();
        for (Store store : stores) {
            foods.addAll(store.getFoods());
            store.clearFoods();
        }
        foods.forEach(food -> distributionProduct(food, nowCalendar));
    }
}
