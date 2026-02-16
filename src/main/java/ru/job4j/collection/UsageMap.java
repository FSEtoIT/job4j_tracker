package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev NashGeroi!");
        map.put("amakeevmindraycom@yandex.ru", "FSE to IT");
        map.put("amakeevmindraycom@yandex.ru", "IT to FSE");
        map.put("StasKorobeinikov@yandex.ru", "Korobeinikov Stas Mentor!");
        map.put("KorobeinikovStas@yandex.ru", "Mentor Korobeinikov Stas!");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}