package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Petr Arsentev");
        student.setGroup("IT-2025");
        student.setJoined(new Date());

        System.out.println(student.getFio() + " from the " + student.getGroup() + " faculty, joined " + student.getJoined());
    }
}
