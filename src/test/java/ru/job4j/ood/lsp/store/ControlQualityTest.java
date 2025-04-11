package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.store.model.Fish;
import ru.job4j.ood.lsp.store.model.Food;
import ru.job4j.ood.lsp.store.model.Meat;
import ru.job4j.ood.lsp.store.model.Milk;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ControlQualityTest {

    @Test
    void whenFoodMilkChoiceShop() {
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(shop, trash, warehouse));
        Food food = new Milk("Молоко",
            new Date(2025, Calendar.FEBRUARY, 15),
            new Date(2025, Calendar.FEBRUARY, 5),
            1000,
            500
        );
        controlQuality.distributionProduct(food, new Date(2025, Calendar.FEBRUARY, 10));
        assertThat(shop.getFoods()).containsOnly(food);
        assertThat(trash.getFoods()).isEmpty();
        assertThat(warehouse.getFoods()).isEmpty();
    }

    @Test
    void whenFoodMilkResortAndChoiceTrash() {
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(shop, trash, warehouse));
        Food food = new Milk("Молоко",
            new Date(2025, Calendar.FEBRUARY, 15),
            new Date(2025, Calendar.FEBRUARY, 5),
            1000,
            500
        );
        controlQuality.distributionProduct(food, new Date(2025, Calendar.FEBRUARY, 10));
        controlQuality.resort(new Date(2026, Calendar.FEBRUARY, 10));
        assertThat(trash.getFoods()).containsOnly(food);
        assertThat(shop.getFoods()).isEmpty();
        assertThat(warehouse.getFoods()).isEmpty();
    }

    @Test
    void whenFoodFishChoiceTrash() {
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(shop, trash, warehouse));
        Food food = new Fish("Рыба", new Date(2025, Calendar.FEBRUARY, 15),
            new Date(2025, Calendar.FEBRUARY, 5),
            1000,
            500
        );
        controlQuality.distributionProduct(food, new Date(2025, Calendar.FEBRUARY, 15));
        assertThat(trash.getFoods()).containsOnly(food);
        assertThat(shop.getFoods()).isEmpty();
        assertThat(warehouse.getFoods()).isEmpty();
    }

    @Test
    void whenFoodFishResortAndChoiceWarehouse() {
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(shop, trash, warehouse));
        Food food = new Fish("Рыба", new Date(2025, Calendar.FEBRUARY, 15),
            new Date(2025, Calendar.FEBRUARY, 5),
            1000,
            500
        );
        controlQuality.distributionProduct(food, new Date(2025, Calendar.FEBRUARY, 15));
        controlQuality.resort(new Date(2024, Calendar.FEBRUARY, 15));
        assertThat(trash.getFoods()).isEmpty();
        assertThat(shop.getFoods()).isEmpty();
        assertThat(warehouse.getFoods()).containsOnly(food);
    }

    @Test
    void whenFoodMeatChoiceWarehouse() {
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(shop, trash, warehouse));
        Food food = new Meat("Мясо", new Date(2025, Calendar.FEBRUARY, 15),
            new Date(2025, Calendar.FEBRUARY, 5),
            1000,
            500
        );
        controlQuality.distributionProduct(food, new Date(2025, Calendar.FEBRUARY, 6));
        assertThat(warehouse.getFoods()).containsOnly(food);
        assertThat(trash.getFoods()).isEmpty();
        assertThat(shop.getFoods()).isEmpty();
    }

    @Test
    void whenFoodMeatResortAndChoiceTrash() {
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(shop, trash, warehouse));
        Food food = new Meat("Мясо", new Date(2025, Calendar.FEBRUARY, 15),
            new Date(2025, Calendar.FEBRUARY, 5),
            1000,
            500
        );
        controlQuality.distributionProduct(food, new Date(2025, Calendar.FEBRUARY, 6));
        controlQuality.resort(new Date(2026, Calendar.FEBRUARY, 6));
        assertThat(warehouse.getFoods()).isEmpty();
        assertThat(trash.getFoods()).containsOnly(food);
        assertThat(shop.getFoods()).isEmpty();
    }

    @Test
    void whenFoodMilkChoiceShopAndWasDiscount() {
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(shop, trash, warehouse));
        Food food = new Milk("Молоко",
            new Date(2025, Calendar.FEBRUARY, 15),
            new Date(2025, Calendar.FEBRUARY, 5),
            1000,
            500
        );
        controlQuality.distributionProduct(food, new Date(2025, Calendar.FEBRUARY, 13));
        assertThat(shop.getFoods()).containsOnly(food);
        assertThat(shop.getFoods().iterator().next().getDiscount()).isEqualTo(800);
        assertThat(trash.getFoods()).isEmpty();
        assertThat(warehouse.getFoods()).isEmpty();
    }
}