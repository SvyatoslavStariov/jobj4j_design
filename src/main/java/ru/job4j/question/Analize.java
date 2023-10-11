package ru.job4j.question;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, User> mapPrevious = previous.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
        Map<Integer, User> mapCurrent = current.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
        Set<User> users = Stream.of(previous, current)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        int add = 0;
        int change = 0;
        int delete = 0;
        for (User user : users) {
            if (mapPrevious.get(user.getId()) == null) {
                add++;
            } else if (mapCurrent.get(user.getId()) == null) {
                delete++;
            } else if (!mapCurrent.get(user.getId()).getName().equals(user.getName())) {
                change++;
            }
        }
        return new Info(add, change, delete);
    }
}
