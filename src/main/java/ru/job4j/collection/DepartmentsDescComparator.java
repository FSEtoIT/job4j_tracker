package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] a1 = left.split("/");
        String[] a2 = right.split("/");
        int result = a2[0].compareTo(a1[0]);

        if (result != 0) {
            return result;
        }
        return left.compareTo(right);
    }
}