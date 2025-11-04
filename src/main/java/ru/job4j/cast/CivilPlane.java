package ru.job4j.cast;

public class CivilPlane extends Plane {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Летает по воздуху на высотах от 9,000 до 10,000 метров");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + " Скорость 700-850 км/ч");
    }
}
