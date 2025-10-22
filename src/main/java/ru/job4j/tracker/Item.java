package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void printInfo() {
        System.out.println("Ваш ID " + id);
        System.out.println("Ваше Имя: " + name);
        System.out.println("=========================");
    }

    public static void main(String[] args) {
        Item item1 = new Item(1, "Ted");
        Item item2 = new Item(2, "Bill");
        Item item3 = new Item();
        item1.printInfo();
        item2.printInfo();
        item3.printInfo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}