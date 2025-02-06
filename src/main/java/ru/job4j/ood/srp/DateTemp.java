package ru.job4j.ood.srp;

/**
 * Класс отвечает за дату и температуру, тем самым у него минимум уже две ответственности. Необходимо выделить классы с ответственностью за
 * температуру, дату и возможно генерацию. И использовать их в классе {@link DateTemp} через композицию.
 */
public class DateTemp {

    public void generateDate() {
    }

    public int getInfoTemp() {
        return 0;
    }
}
