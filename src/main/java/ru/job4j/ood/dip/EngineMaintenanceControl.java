package ru.job4j.ood.dip;

/**
 * Нарушение DI в зависимости возвращаемого значения {@link GasolineEngine}.
 * Необходимо указать {@link Engine}.
 */
public interface EngineMaintenanceControl {

    GasolineEngine findEngine(int serialNumber);
}
