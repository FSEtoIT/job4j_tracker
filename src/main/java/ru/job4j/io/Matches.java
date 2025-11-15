package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean turn = true;
        int count = 11;

        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println("На столе осталось " + count + " спичек.");
            System.out.println(player + " введите число от 1 до 3:");
            String line = input.nextLine();
            int matches = Integer.parseInt(line);
            boolean validMove = true;

            if (matches < 1 || matches > 3) {
                System.out.println("Можно брать только от 1 до 3 спичек!");
                validMove = false;
            } else if (matches > count) {
                System.out.println("Нельзя взять больше спичек, чем осталось!");
                validMove = false;
            }

            if (validMove) {
                count -= matches;

                if (count == 0) {
                    System.out.println(player + " взял последнюю спичку!");
                    break;
                }

                turn = !turn; // ход переключается только при корректном ходе
            }
        }

        if (!turn) {
            System.out.println("\nВыиграл первый игрок!");
        } else {
            System.out.println("\nВыиграл второй игрок!");
        }
    }
}