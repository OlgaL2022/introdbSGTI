package com.company.Menu;

import com.company.controllers.BookController;
import com.company.controllers.StudentController;
import com.company.objects.Book;
import com.company.objects.Student;

import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class BookMenu {

    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?: ");
        System.out.println("1. Add a new book");
        System.out.println("2. Get book by id");
        System.out.println("3. Edit the name of a book");
        System.out.println("4. Delete a book by id");

        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println(BookController.addBook() ? "Successfully added new book" : "Book not added");
                break;
            case 2:
                System.out.println(BookController.getBookById().getName());
                break;
            case 3:
                System.out.println(BookController.editBookName() ? "Successfully changed book name" : "Book name has not changed");
                break;
            case 4:
                System.out.println(BookController.deleteBook() ? "Successfully deleted book" : "Book was not deleted");
                break;
            default:
                System.out.println("Invalid option. Try again");
                menu();
        }

    }

}


