package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println("На столе осталось " + count + " спичек.");
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;
            /* Остальная логика игры. */
            if (matches < 1 || matches > 3) {
                System.out.println("Можно брать только от 1 до 3 спичек!\n");
                continue;
            }
            if (matches > count) {
                System.out.println("Нельзя взять больше спичек, чем осталось!\n");
                continue;
            }
            count -= matches;
            if (count == 0) {
                // Тот, кто сделал этот ход, проигрывает
                System.out.println(player + " взял последнюю спичку!");
                break;
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}