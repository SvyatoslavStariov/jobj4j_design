package ru.job4j.ood.lsp.model;

/**
 * Нарушения принципа LSP в том, что в наследнике усилено предусловие метод 'validate'
 */
public class ClientVIP extends Client {

    public ClientVIP(String userId, String userName, int age) {
        super(userId, userName, age);
    }

    @Override
    protected void validate(int age) {
        if (age < 16) {
            throw new IllegalArgumentException("Too young!");
        }
    }
}
