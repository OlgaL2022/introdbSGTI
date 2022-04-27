package com.company.objects;

import com.company.Menu.BookMenu;
import com.company.Menu.StudentMenu;
import com.company.dbhelper.DbConnection;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //DbConnection.getConnection();

        //StudentMenu.menu();

        BookMenu.menu();

        /*Scanner scanner = new Scanner(System.in);

        try {
            scanner.nextInt();
        } catch (Exception e) {
            System.out.println("The value is not a string");
        }*/

       /* float priceLimit = 5;

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
        }*/
        //System.out.println(books.stream().filter(b -> b.getPrice() > 5).collect(Collectors.toList()).toString());



       /* Teacher's example:
       public static List<String> filterLessThanFive(List<Book> books) {
            // an anonymous function - lambda
            //        books.removeIf(book -> book.getPrice() < 5);
            //        return books;

            // Define a list of string for the booknames
            List<String> bookNames = new ArrayList<>();

            // Use a loop to filter the books less than 5
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getPrice() < 5) books.remove(books.get(i));
            }

            // add each remaining book name to the bookNames list.
            books.forEach(book -> bookNames.add(book.getName()));

            // return the list of book names.
            return bookNames;*/
        }
    }
       // System.out.println(filterLessThanFivefive(books));

