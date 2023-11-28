package ru.job4j.serialization.xml;

public class City {
    private String address;

    private String inn;

    public City(String address, String inn) {
        this.address = address;
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "City{"
                + "address='" + address + '\''
                + ", inn='" + inn + '\''
                + '}';
    }
}
