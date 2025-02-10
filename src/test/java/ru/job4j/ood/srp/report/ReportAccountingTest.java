package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportAccountingTest {

    @Test
    public void whenGeneratedAccountingReport() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportAccounting(store, new InMemoryCurrencyConverter(), Currency.RUB, Currency.USD, parser);
        StringBuilder expected = new StringBuilder()
            .append("Name; Hired; Fired; Salary;")
            .append(System.lineSeparator())
            .append(worker.getName()).append(" ")
            .append(parser.parse(worker.getHired())).append(" ")
            .append(parser.parse(worker.getFired())).append(" ")
            .append(converter.convert(Currency.RUB, worker.getSalary(), Currency.USD))
            .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}
