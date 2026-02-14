package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    void whenAddDuplicatePassportThenReturnFalse() {
        PassportOffice office = new PassportOffice();
        Citizen first = new Citizen("1234", "Ivan");
        Citizen second = new Citizen("1234", "Petr");

        office.add(first);
        boolean result = office.add(second);

        assertThat(result).isFalse();
    }
}