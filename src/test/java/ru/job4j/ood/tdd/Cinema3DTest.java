package ru.job4j.ood.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class Cinema3DTest {

    @Test
    public void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isEqualTo(new Ticket3D());
    }

    @Test
    public void whenAddSessionThenItExistsBetweenAllSessions() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(data -> true);
        assertThat(sessions).contains(session);
    }

    @Test
    public void whenSessionIsNullThenGetException() {
        Cinema cinema = new Cinema3D();
        assertThatThrownBy(() -> cinema.add(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenNoSessionsFoundThenEmptyList() {
        Cinema cinema = new Cinema3D();
        List<Session> actual = cinema.find(session -> false);
        List<Session> expected = Collections.emptyList();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenBuyOnInvalidColumnThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, 1, -1, date))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, -1, 1, date))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuyOnPastDateThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = new GregorianCalendar(2025, Calendar.JANUARY, 14);
        assertThatThrownBy(() -> cinema.buy(account, 0, 0, date))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuyOnNullAccountThenGetException() {
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(null, 0, 0, date))
            .isInstanceOf(IllegalArgumentException.class);
    }
}