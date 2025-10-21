package ru.job4j.checkstyle;

public class Broken {
    public static final String NEWVALUE = "";
    private int sizeOfEmpty = 10;
    private String name;
    public String surname;

    public Broken() { }

    void echo() { }

    void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    void method1(int a, int b, int c, int d) { }

    void method2(int e, int f, int g, int h) { }
}
