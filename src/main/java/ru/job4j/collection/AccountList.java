package ru.job4j.collection;

import java.util.*;

public class AccountList {

    private final String name;
    private final int age;

    public AccountList(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " age: " + age;
    }

    public static void main(String[] args) {

        List<AccountList> list = new ArrayList<>();
        list.add(new AccountList("Petr Arsentev", 52));
        list.add(new AccountList("Petr Arsentev", 42));
        list.add(new AccountList("Andrey FSE", 42));
        list.add(new AccountList("Andrey FSE", 32));
        list.add(new AccountList("Stas Korobeinikov", 22));
        list.add(new AccountList("Stas Korobeinikov", 32));

        System.out.println("==== Before sorting list ====");
        for (AccountList account : list) {
            System.out.println(account);
        }
        System.out.println();

        Map<String, Integer> map = new TreeMap<>();
        for (AccountList account : list) {
            String name = account.getName();
            int age = account.getAge();

            if (map.containsKey(name)) {
                int currentMax = map.get(name);
                if (age > currentMax) {
                    map.put(name, age);
                }
            } else {
                map.put(name, age);
            }
        }

        System.out.println("==== After sorting list ====");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " age: " + entry.getValue());
        }
    }
}
