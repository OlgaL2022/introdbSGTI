package com.company.Menu;

import com.company.controllers.AuthorController;
import com.company.controllers.BookController;
import com.company.objects.Author;

import java.util.Scanner;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class AuthorMenu {
    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?: ");
        System.out.println("1. Add a new author");
        System.out.println("2. Get author by id");
        System.out.println("3. Delete author");

        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println(AuthorController.addAuthor());
                break;
            case 2:
                System.out.println(isNull(AuthorController.getAuthorById())? "Author not found" : "");
                break;
            case 3:
                System.out.println(AuthorController.deleteAuthor());
                break;
            default:
                System.out.println("Invalid option. Try again");
                menu();
        }

    }

}



