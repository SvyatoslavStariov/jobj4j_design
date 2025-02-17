package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.store.model.Food;

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
}
