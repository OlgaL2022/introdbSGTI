package com.company.controllers;

import com.company.dbhelper.DbConnection;
import com.company.objects.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class BookController {

    // initialize scanner
    private static Scanner scanner = new Scanner(System.in);
    //private static Connection connection = DbConnection.getConnection();
    private static PreparedStatement ps;
    private static ResultSet rs;

    // add book controller
    public static boolean addBook() {
        System.out.print("Enter the name of the book: ");
        String name = scanner.next();

        System.out.print("Enter the price of the book: ");
        float price = scanner.nextFloat();

        try {
            // INSERT INTO books(name, price) VALUES ('name', price);
            ps = getConnection().prepareStatement("INSERT INTO books(name, price) VALUES('" + name + "'," + price + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }

    public static Book getBookById() {
        System.out.print("Enter the id of the book: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM books WHERE id =" + id);
            rs = ps.executeQuery();

            int bookId;
            float price;
            String name;

            Book book = new Book();

            while (rs.next()) {
                bookId = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getFloat("price");
                book.setName(name);
                book.setId(bookId);
                book.setPrice(price);
            }
            return book;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean editBookName() {

        System.out.println("Enter the id of the book you want to change: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the name of the book you want to change: ");
        String name = scanner.nextLine();

        System.out.println("Enter the new name for '" + name + "': ");
        String newName = scanner.nextLine();

        try {
            // UPDATE books set name = 'name' where id = id;
            ps = getConnection().prepareStatement("UPDATE books SET name ='" + newName + "' WHERE id=" + id + ";");
            ps.execute(); //execute the sql command
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;

        }

    }
    public static boolean deleteBook() {

        System.out.print("Enter the id of the book: ");
        int id = scanner.nextInt();

        try {
            // DELETE FROM books WHERE id = id;
            ps = getConnection().prepareStatement("DELETE FROM books WHERE id=" + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }
    }

}


