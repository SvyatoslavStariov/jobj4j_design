package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.store.model.Food;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractStore implements Store {

    protected final List<Food> foods = new ArrayList<>();

    @Override
    public void saveFood(Food food, Date nowCalendar) {
        int percent = percentWear(food.getCreateDate(), food.getExpiryDate(), nowCalendar);
        if (!isIncludeRangePercent(percent)) {
            return;
        }
        specialDiscount(percent).accept(food);
        foods.add(food);
    }

    protected int percentWear(Date createDate, Date expiryDate, Date nowCalendar) {
        double differenceTodayCreateTime = nowCalendar.getTime() - createDate.getTime();
        double differenceExpiryCreateTime = expiryDate.getTime() - createDate.getTime();
        return (int) (differenceTodayCreateTime * 100 / differenceExpiryCreateTime);
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }

    public List<Food> getFoods() {
        return foods;
    }

    protected abstract boolean isIncludeRangePercent(int percent);

    protected abstract Consumer<? super Food> specialDiscount(int percent);
}
