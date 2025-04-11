package ru.job4j.ood.dip;

/**
 * Тут проблема DI Связанная с полем. У нас есть прямая зависимость на бензиновый двигатель
 * {@link GasolineEngine}, для решения проблемы нужна зависимость на абстракцию {@link Engine}.
 */
public class Vehicle extends Car {

    private GasolineEngine gasolineEngine;
}
