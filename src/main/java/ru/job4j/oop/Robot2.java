package ru.job4j.oop;

public class Robot2 {

    public static boolean isBackToStart(String[] moves) {
        int indexX = 0;
        int indexY = 0;

        for (String move : moves) {
            switch (move) {
                case "Up":
                    indexY++;
                    break;
                case "Down":
                    indexY--;
                    break;
                case "Left":
                    indexX--;
                    break;
                case "Right":
                    indexX++;
                    break;
                default:
                    throw new IllegalStateException("Unknown move: " + move + " . You may use commands \"UP/DOWN/LEFT/RIGHT\" only!");
            }
        }

        return indexX == 0 && indexY == 0;
    }
}