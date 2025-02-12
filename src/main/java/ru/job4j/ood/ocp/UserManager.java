package ru.job4j.ood.ocp;

/**
 * Класс работы с пользователями в зависимости от должности. При добавлении новой должности будет нарушен
 * принцип OCP т.к. класс открыт для модификации, что бы данный класс следовал принципам OCP, необходимо рассмотреть
 * паттерн Strategy, общий и неизменный алгоритм которого будет содержаться в классе CONTEXT, а расширяемым будет интерфейс
 * UserStrategy, имплементирующие его классы будут содержать должности и логику ее обработки,
 * добавляя новый класс к UserStrategy мы будем его расширять.
 */
public class UserManager {

    private void doSomeThing(UserPosition userPosition) {
        if (userPosition == UserPosition.WORKER) {
            doSomeThing();
        } else if (userPosition == UserPosition.MANAGER) {
            doSomeThing();
        } else if (userPosition == UserPosition.DIRECTOR) {
            doSomeThing();
        } else {
            doSomeThing();
        }
    }

    private void doSomeThing() {
    }
}
