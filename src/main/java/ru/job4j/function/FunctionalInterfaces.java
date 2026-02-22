package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer =
                (key, value) -> map.put(key, value);

        biConsumer.accept(1, "one");
        biConsumer.accept(2, "two");
        biConsumer.accept(3, "three");
        biConsumer.accept(4, "four");
        biConsumer.accept(5, "five");
        biConsumer.accept(6, "six");
        biConsumer.accept(7, "seven");
        System.out.println(map);

        BiPredicate<Integer, String> biPredicate =
                (key, value) -> key % 2 == 0 || value.length() == 4;

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (biPredicate.test(entry.getKey(), entry.getValue())) {
                    System.out.println("key: " + entry.getKey()
                            + " value: " + entry.getValue());
                }
        }

        Supplier<List<String>> supplier =
                () -> new ArrayList<>(map.values());
        List<String> strings = supplier.get();

        Consumer<String> consumer =
                (string) -> System.out.println(string);
        consumer.accept(String.valueOf(supplier.get()));

        Function<String, String> function =
                string -> string.toUpperCase();
        for (String string : strings) {
            String upper = function.apply(string);
            consumer.accept(upper);
        }
    }
}