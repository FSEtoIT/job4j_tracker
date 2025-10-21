package ru.job4j.oop;

public class Wolf {
    public void tryEat(Ball ball) {
        ball.tryRun(true);
        System.out.println("колобок будет съеден Волком");
    }
}
