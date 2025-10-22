package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int divide(int y) {
        return x / y;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int result1 = sum(10);
        System.out.println("sum: " + result1);
        Calculator calculator = new Calculator();
        int result2 = calculator.multiply(10);
        System.out.println("multiply: " + result2);
        int result3 = minus(10);
        System.out.println("minus: " + result3);
        int result4 = calculator.divide(10);
        System.out.println("divide: " + result4);
        int result5 = calculator.sumAllOperation(10);
        System.out.println("sumAllOperation: " + result5);
    }
}