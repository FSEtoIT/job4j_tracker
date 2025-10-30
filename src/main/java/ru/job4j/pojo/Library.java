package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book intern = new Book("Clean code", 0);
        Book junior = new Book("Semi-Clean code", 4);
        Book middle = new Book("Middle code", 10);
        Book senior = new Book("Full code", 19);
        Book[] books = new Book[4];
        books[0] = intern;
        books[1] = junior;
        books[2] = middle;
        books[3] = senior;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println("Massive #:" + " " + index + " - " + book.getName() + " - " + book.getCountLists() + " pages");
        }
        System.out.println("Replace books with index 0 and 3.");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println("Massive #:" + " " + index + " - " + book.getName() + " - " + book.getCountLists() + " pages");
        }
        System.out.println("Shown only books with name = Clean code");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getName().equals("Clean code")) {
                System.out.println("Massive #:" + " " + index + " - " + book.getName() + " - " + book.getCountLists() + " pages");
            }
        }
    }
}
