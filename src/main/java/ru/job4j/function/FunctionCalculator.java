package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCalculator {
    public List<Double> diapason(int start, int end, Function<Double, Double> function) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(function.apply((double) i));
        }
        return result;
    }

    public static void main(String[] args) {
        FunctionCalculator calculator = new FunctionCalculator();
        List<Double> linear = calculator.diapason(1, 5, x -> 2 * x + 1);

        List<Double> quadro = calculator.diapason(1, 5, x -> 2 * x * x + 3 * x + 4);

        List<Double> exponent = calculator.diapason(1, 5, x -> Math.pow(2, x));

    }
}