package ru.job4j.ood.srp;

/**
 * У класса есть ответственность за управление пользователем и за отправку уведомлений. Необходимо создать класс управления уведомлениями.
 * Если есть необходимость выделить фасад или добавить в UserManager зависимость на класс управления уведомлениями через композицию.
 */
public class UserManager {

    public void create(String firstName, String lastName, int age) {

    }

    public void update(String userId, String firstName, String lastName, int age) {

    }

    public void delete(String firstName, String lastName) {

    }

    public void notification(String userId, String message) {

    }
}
