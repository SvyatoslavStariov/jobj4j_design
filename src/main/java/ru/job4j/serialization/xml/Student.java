package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlAttribute
    private String name;

    @XmlAttribute
    private int age;

    @XmlAttribute
    private String sex;

    private City city;

    private List<String> subjects;

    public Student() {
    }

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

    public static void main(String[] args) throws Exception {
        Student student = new Student("Андрей", 30, "Муж", new City("г.Москва", "4534534"), List.of("Биология", "Химия"));
        JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(student, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Student result = (Student) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}