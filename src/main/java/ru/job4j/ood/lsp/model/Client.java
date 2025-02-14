package ru.job4j.ood.lsp.model;

public class Client {

    private String userId;

    private String userName;

    private int age;

    public Client(String userId, String userName, int age) {
        validate(age);
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    }

    protected void validate(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Too young!");
        }
    }
}
