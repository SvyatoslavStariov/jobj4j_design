package ru.job4j.ood.ocp;

/**
 * Класс валидации покупки билетов на аттракцион. Принцип OCP нарушается тем,
 * что при добавлении нового аттракциона или новых правил для возраста и роста пользователя,
 * то придется изменять существующие методы.
 * Необходимо выделить интерфейс и определить контракт, которые будут имплементировать конкретные аттракционы.
 */
public class TicketAttraction {

    private void validationBuyTicket(String attractionType, String ticketId, int age) {
        if ("someThingAttraction".equals(attractionType) && age < 18) {
            return;
        }
    }
}
