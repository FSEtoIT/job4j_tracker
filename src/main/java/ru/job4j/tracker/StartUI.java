package ru.job4j.tracker;

public class StartUI {

    public static void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("=== Войти в подменю: ");
            if (select == 0) {
                add(input, tracker);
            } else if (select == 1) {
                findAll(tracker);
            } else if (select == 2) {
                replace(input, tracker);
            } else if (select == 3) {
                delete(input, tracker);
            } else if (select == 4) {
                findById(input, tracker);
            } else if (select == 5) {
                findByName(input, tracker);
            } else if (select == 6) {
                System.out.println("=== Завершение работы. ===");
                run = false;
            }
        }
    }

    private static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Вывод заявок по имени ===");
        String name = input.askStr("=== Введите имя: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("=== Заявки с именем: " + name + " не найдены. ===");
        }
    }

    private static void findById(Input input, Tracker tracker) {
        System.out.println("=== Вывод заявки по id ===");
        int id = input.askInt("=== Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("=== Заявка с введенным id: " + id + " не найдена. ====");
        }
    }

    private static void delete(Input input, Tracker tracker) {
        System.out.println("=== Удаление заявки ===");
        int id = input.askInt("=== Введите id: ");
        Item item = tracker.findById(id);
        tracker.delete(id);
        System.out.println(item != null ? "=== Заявка удалена успешно. ===" : "=== Ошибка удаления заявки.===");
    }

    private static void replace(Input input, Tracker tracker) {
        System.out.println("=== Редактирование заявки ===");
        int id = input.askInt("=== Введите id: ");
        String name = input.askStr("=== Введите имя: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("=== Заявка изменена успешно.===");
        } else {
            System.out.println("=== Ошибка замены заявки.===");
        }
    }

    private static void findAll(Tracker tracker) {
        System.out.println("=== Вывод всех заявок ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("=== Хранилище еще не содержит заявок ===");
        }
    }

    public static void add(Input input, Tracker tracker) {
        System.out.println("=== Создание новой заявки ===");
        String name = input.askStr("=== Введите имя: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("=== Добавленная заявка: " + item + " ===");
    }

    private static void showMenu() {
        String[] menu = {
                "Добавить новую заявку", "Показать все заявки", "Изменить заявку",
                "Удалить заявку", "Показать заявку по id", "Показать заявки по имени",
                "Завершить программу"
        };
        System.out.println("\n=========Меню:=========");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}