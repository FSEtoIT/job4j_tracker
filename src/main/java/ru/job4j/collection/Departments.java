package ru.job4j.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String value : departments) {
            String[] parts = value.split("/");
            String start = parts[0];
            temp.add(start);
            String path = start;
            for (int i = 1; i < parts.length; i++) {
                path = path + "/" + parts[i];
                temp.add(path);
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
    /*
// Удалено за ненадобностью

    public static void sortAsc(List<String> departments) {
        departments.sort(new DepartmentsAscComparator());
    }
     */
}