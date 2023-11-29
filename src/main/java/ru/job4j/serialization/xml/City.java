package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city")
public class City {

    @XmlAttribute
    private String address;

    @XmlAttribute
    private String inn;

    public City() {
    }

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
