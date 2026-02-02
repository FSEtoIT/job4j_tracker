package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    public void whenNumberIsNegativeThenThrowIllegalArgumentException() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () ->
                        factorial.calc(-1)
        );
        assertEquals("Number could not be less than 0", exception.getMessage());
    }

    @Test
    public void whenNumberIsPositiveThenCalculateFactorialCorrectly() {
        Factorial factorial = new Factorial();

        int result = factorial.calc(5);

        assertEquals(120, result);
    }
}