package ru.job4j.cast;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Ездит по дорогам");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + " Скорость 20-70 км/ч");
    }
}
