package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsAscComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] a1 = left.split("/");
        String[] a2 = right.split("/");
        int result = a1[0].compareTo(a2[0]);

        return result != 0 ? result : left.compareTo(right);
    }
}