package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] a1 = left.split("/");
        String[] a2 = right.split("/");
        int len = Math.min(a1.length, a2.length);

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                int cmp = a2[i].compareTo(a1[i]);
                if (cmp != 0) {
                    return cmp;
                }
            } else {
                int cmp = a1[i].compareTo(a2[i]);
                if (cmp != 0) {
                    return cmp;
                }
            }
        }
        return Integer.compare(a1.length, a2.length);
    }
}
