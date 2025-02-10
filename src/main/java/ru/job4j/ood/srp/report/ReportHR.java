package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportHR implements Report {

    private final Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
            .append(System.lineSeparator());

        LinkedHashMap<Double, Employee> collect = store.findBy(filter)
            .stream()
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .collect(Collectors.toMap(Employee::getSalary,
                Function.identity(), (empl1, empl2) -> empl1, LinkedHashMap::new));

        for (Map.Entry<Double, Employee> doubleEmployeeEntry : collect.entrySet()) {
            text.append(doubleEmployeeEntry.getValue().getName()).append(" ")
                .append(doubleEmployeeEntry.getKey())
                .append(System.lineSeparator());
        }
        return text.toString();
    }
}
