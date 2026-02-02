package ru.job4j.ex;

public class Main {

    public static void main(String[] args) {
        String[] names = {"Petr", "Ivan", "Stepan"};

        try {
            int index = FindEl.indexOf(names, "Andrey");
            System.out.println("Index: " + index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
