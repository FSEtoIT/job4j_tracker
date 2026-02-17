package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByName() {
        Job first = new Job("Fix bug", 1);
        Job second = new Job("Impl task", 1);
        JobAscByName comparator = new JobAscByName();
        int rsl = comparator.compare(first, second);
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescByName() {
        Job first = new Job("Impl task", 1);
        Job second = new Job("Fix bug", 1);
        JobDescByName comparator = new JobDescByName();
        int rsl = comparator.compare(first, second);
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByPriority() {
        Job first = new Job("Impl task", 1);
        Job second = new Job("Fix bug", 2);
        JobAscByPriority comparator = new JobAscByPriority();
        int rsl = comparator.compare(first, second);
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescByPriority() {
        Job first = new Job("Fix bug", 2);
        Job second = new Job("Impl task", 1);
        JobDescByPriority comparator = new JobDescByPriority();
        int rsl = comparator.compare(first, second);
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescByNameAndDescByPriority() {
        Comparator<Job> comparator =
                new JobDescByName().thenComparing(new JobDescByPriority());

        int rsl = comparator.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 2)
        );

        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByNameAndAscByPriority() {
        Comparator<Job> comparator =
                new JobAscByName().thenComparing(new JobAscByPriority());

        int rsl = comparator.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 2)
        );

        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByNameAndDescByPriorityAndNamesEqual() {
        Comparator<Job> comparator =
                new JobAscByName().thenComparing(new JobDescByPriority());

        int rsl = comparator.compare(
                new Job("Fix bug", 2),
                new Job("Fix bug", 1)
        );

        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescByNameAndAscByPriorityAndNamesEqual() {
        Comparator<Job> comparator =
                new JobDescByName().thenComparing(new JobAscByPriority());

        int rsl = comparator.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 2)
        );

        assertThat(rsl).isLessThan(0);
    }
}