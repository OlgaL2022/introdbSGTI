package com.company.objects;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);

        try {
            scanner.nextInt();
        } catch (Exception e) {
            System.out.println("The value is not a string");
        }*/

        float priceLimit = 5;

        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Effective Java", 20.1f));
        books.add(new Book(2, "English for students", 4.50f));
        books.add(new Book(3, "French for beginners", 6.50f));
        books.add(new Book(4, "Modern science fiction", 15.70f));
        books.add(new Book(5, "History of England", 30));

        for (Book book: books) {
            if (book.getPrice() > priceLimit) {
                System.out.println(book.getName() + " costs more than " + (int)priceLimit + " usd.");
            }
        }

    }
}
