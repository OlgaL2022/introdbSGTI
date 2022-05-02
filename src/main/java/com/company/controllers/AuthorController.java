package com.company.controllers;
import com.company.objects.Author;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static com.company.dbhelper.DbConnection.getConnection;

public class AuthorController {
    // Create an authors table with the following properties: Id, name, age and bookid and
    // create the corresponding class in your code and write methods to add, getbyid and delete a book’s author.

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addAuthor() {

        System.out.print("Enter author's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter author's age: ");
        int age = scanner.nextInt();

        System.out.print("Enter author's book id: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("INSERT INTO authors(author_name, age, bookid) VALUES('" + name + "'," + age + "," + id +")");
            ps.execute();
            System.out.println("Added successfully");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Author getAuthorById() {
        System.out.print("Enter author's id: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM authors WHERE id=" + id);
            rs = ps.executeQuery();

            if(rs.next()) {
                return new Author(rs.getInt("id"), rs.getString("author_name"), rs.getInt("age"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean deleteAuthor() {
        System.out.print("Enter author's id: ");
        int id = scanner.nextInt();


        try {
            ps = getConnection().prepareStatement("DELETE FROM authors WHERE id =" + id);
            ps.execute();
            System.out.println("Deleted successfully");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}


