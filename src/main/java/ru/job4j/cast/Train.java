package ru.job4j.cast;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Ездит по рельсам");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + " Скорость 40-400 км/ч");
    }
}
