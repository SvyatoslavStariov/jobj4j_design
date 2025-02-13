package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class XmlReportEngine implements Report {

    private final Store store;

    private final DateTimeParser<Calendar> parser;

    public XmlReportEngine(Store store, DateTimeParser<Calendar> parser) {
        this.store = store;
        this.parser = parser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setAdapter(new CalendarAdapterXml(parser));
            marshaller.marshal(new Employees(employees), writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
