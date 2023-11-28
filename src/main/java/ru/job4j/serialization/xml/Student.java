package ru.job4j.serialization.xml;

import java.util.List;

public class Student {
    private String name;

    private int age;

    private String sex;

    private City city;

    private List<String> subjects;

    public Student(String name, int age, String sex, City city, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.city = city;
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", sex='" + sex + '\''
                + ", city=" + city
                + ", subjects=" + subjects
                + '}';
    }
}