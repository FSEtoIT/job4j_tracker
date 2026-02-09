package ru.job4j.oop;

public class Robot {

    public static boolean isBackToStart(String[] moves) {
        int moveUp = 0;
        int moveDown = 0;
        int moveLeft = 0;
        int moveRight = 0;

        for (String move : moves) {
            switch (move) {
                case "Up":
                    moveUp++;
                    break;
                case "Down":
                    moveDown++;
                    break;
                case "Left":
                    moveLeft++;
                    break;
                case "Right":
                    moveRight++;
                    break;
                default:
                    throw new IllegalStateException("Unknown move: " + move + " . You may use commands \"UP/DOWN/LEFT/RIGHT\" only!");
            }
        }

        return moveUp == moveDown && moveLeft == moveRight;
    }
}