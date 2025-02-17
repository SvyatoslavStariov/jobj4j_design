package ru.job4j.ood.lsp.store.model;

import java.util.Date;

public class Milk extends Food {

    public Milk(String name,
                Date expiryDate,
                Date createDate,
                long price,
                long discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
