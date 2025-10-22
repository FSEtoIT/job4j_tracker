package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public static void main(String[] args) {
        Error error = new Error(true, 500, "Intel Core I7-10700K");
        Error error1 = new Error();
        Error error2 = new Error(false, -1, "Why you wanna killme?! (c)Batman");
        error.printInfo();
        error1.printInfo();
        error2.printInfo();
    }

    public void printInfo() {
        System.out.println("Много мониторов: " + active);
        System.out.println("SSD: " + status + " GB");
        System.out.println("Модель CPU: " + message);
    }
}
