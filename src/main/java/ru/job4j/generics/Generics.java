package ru.job4j.generics;

import java.util.Iterator;
import java.util.List;

public class Generics {

    public void printObject(List<?> list) {
        for (Iterator<?> iterator = list.iterator(); iterator.hasNext(); ) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next.getClass());
        }
    }

    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Iterator<? extends Predator> iterator = list.iterator(); iterator.hasNext(); ) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next.getClass());
        }
    }

    public void printLowerBoundedWildCard(List<? super Predator> list) {
        for (Iterator<? super Predator> iterator = list.iterator(); iterator.hasNext(); ) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next.getClass());
        }
    }
}