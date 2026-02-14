package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double total = 0;
        int count = 0;

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                total += subject.score();
                count++;
            }
        }
        return count == 0 ? 0D : total / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();

        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            double avg = pupil.subjects().isEmpty() ? 0 : sum / pupil.subjects().size();
            result.add(new Label(pupil.name(), avg));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(),
                        map.getOrDefault(subject.name(), 0) + subject.score());
            }
        }

        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(new Label(
                    entry.getKey(),
                    (double) entry.getValue() / pupils.size()
            ));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();

        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            result.add(new Label(pupil.name(), sum));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(),
                        map.getOrDefault(subject.name(), 0) + subject.score());
            }
        }

        List<Label> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(new Label(entry.getKey(), entry.getValue()));
        }

        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}