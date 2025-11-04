package ru.job4j.cast;

public class SmallPlane extends Plane {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Летает по воздуху на высотах до 1,000 метров");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + " Скорость 180-250 км/ч");
    }
}
