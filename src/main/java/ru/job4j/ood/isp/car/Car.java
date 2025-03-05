package ru.job4j.ood.isp.car;

/**
 * Мы используем интерфейс для машин, поведение которых будет одинаково до тех пор, пока мы создадим классы имплементирующие интерфейс с разделением
 * на обычные автомобили и электромобили, в данных методах ключевое отличие будет между баком и батарей. Это отличие и является нарушением ISP
 */
public interface Car {

    void start();

    void stop();

    void movement();

    /**
     * {@link UnsupportedOperationException} - Для электромобилей.
     * Вынести в отдельный интерфейс.
     */
    void gasTank();

    /**
     * {@link UnsupportedOperationException} - Для автомобилей.
     * Вынести в отдельный интерфейс.
     */
    void chargeBattery();
}