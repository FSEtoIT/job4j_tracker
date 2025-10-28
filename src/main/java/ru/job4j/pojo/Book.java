package ru.job4j.pojo;

public class Book {
    private String name;
    private int countLists;

    public Book(String name, int countLists) {
        this.name = name;
        this.countLists = countLists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountLists() {
        return countLists;
    }

    public void setCountLists(int countLists) {
        this.countLists = countLists;
    }
}
