package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    void whenSortAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Charlie"));
        items.add(new Item(2, "Bravo"));
        items.add(new Item(3, "Alpha"));

        Collections.sort(items, new ItemAscByName());

        List<Item> expected = List.of(
                new Item(3, "Alpha"),
                new Item(2, "Bravo"),
                new Item(1, "Charlie")
        );

        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenSortDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Charlie"));
        items.add(new Item(2, "Bravo"));
        items.add(new Item(3, "Alpha"));

        Collections.sort(items, new ItemDescByName());

        List<Item> expected = List.of(
                new Item(1, "Charlie"),
                new Item(2, "Bravo"),
                new Item(3, "Alpha")
        );

        assertThat(items).isEqualTo(expected);
    }
}