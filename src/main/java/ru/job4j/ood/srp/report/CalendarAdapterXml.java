package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Calendar;

public class CalendarAdapterXml extends XmlAdapter<String, Calendar> {

    private final DateTimeParser<Calendar> parser;

    public CalendarAdapterXml(DateTimeParser<Calendar> parser) {
        this.parser = parser;
    }

    @Override
    public Calendar unmarshal(String calendar) throws Exception {
        return null;
    }

    @Override
    public String marshal(Calendar calendar) throws Exception {
        return parser.parse(calendar);
    }
}
