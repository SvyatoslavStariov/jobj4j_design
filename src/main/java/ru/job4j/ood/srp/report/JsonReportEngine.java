package ru.job4j.ood.srp.report;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class JsonReportEngine implements Report {

    private final Store store;

    private final DateTimeParser<Calendar> parser;

    public JsonReportEngine(Store store, DateTimeParser<Calendar> parser) {
        this.store = store;
        this.parser = parser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        var library = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeHierarchyAdapter(
                Calendar.class,
                (JsonSerializer<Calendar>) (calendar, type, jsonSerialization) -> new JsonPrimitive(parser.parse(calendar)))
            .create();
        return library.toJson(employees);
    }
}
