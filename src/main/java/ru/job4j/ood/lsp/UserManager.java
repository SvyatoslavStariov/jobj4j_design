package ru.job4j.ood.lsp;

import ru.job4j.ood.lsp.model.Client;
import ru.job4j.ood.lsp.model.ClientVIP;

/**
 * Нарушения принципа LSP. Допущено изменение логики для дочерних классов, особая логика поведения.
 * Так же нарушение принципа OCP, класс открыт для модификаций.
 */
public class UserManager {

    public void send(Client client) {
        if (client.getClass() == Client.class) {
            doSomething();
        } else if (client.getClass() ==  ClientVIP.class) {
            doSomething();
        }
    }

    private void doSomething() {
    }
}
