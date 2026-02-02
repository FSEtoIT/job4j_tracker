package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenCorrectInput() {
        Output output = new StubOutput();
        Input in = new MockInput(new String[]{"42"}); // правильный ввод
        ValidateInput input = new ValidateInput(output, in);

        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(42);
    }

    @Test
    void whenMultipleCorrectInputs() {
        Output output = new StubOutput();
        Input in = new MockInput(new String[]{"1", "5", "9"}); // несколько чисел
        ValidateInput input = new ValidateInput(output, in);

        int first = input.askInt("Enter menu:");
        int second = input.askInt("Enter menu:");
        int third = input.askInt("Enter menu:");

        assertThat(first).isEqualTo(1);
        assertThat(second).isEqualTo(5);
        assertThat(third).isEqualTo(9);
    }

    @Test
    void whenNegativeNumberInput() {
        Output output = new StubOutput();
        Input in = new MockInput(new String[]{"-7"}); // отрицательное число
        ValidateInput input = new ValidateInput(output, in);

        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-7);
    }
}