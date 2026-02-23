package ru.job4j.stream;

import java.util.List;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(product -> {
                    int diff = product.getStandard() - product.getActual();
                    return diff >= 0 && diff <= 3;
                })
                .map(product -> new Label(product.getName(), product.getPrice() / 2).toString())
                .toList();
    }
}