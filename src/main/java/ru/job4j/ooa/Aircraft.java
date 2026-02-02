package ru.job4j.ooa;

public abstract class Aircraft {

    public void printModel() {
        System.out.println("Метод выводит в консоль модель самолета.");
    }

    public abstract void printCountEngine();
}