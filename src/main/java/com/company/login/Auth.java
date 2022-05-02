package com.company.login;

import javax.swing.text.DefaultEditorKit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class Auth {
    // Authentication

    // Create a table called users that has the following fields:
    // id serial, primary key
    // username -> varchar(255) unique
    // password -> varchar (255)
    // role -> varchar (255)

    // Write a method to sign up users on this student management platform
    // that allows them to add a user name and a password and a role
    // The role is on of two items(user and admin)
    // validate it such that anything else that is entered is not passed to the db
    // make the username unique(you can choose to make the username as email instead)

/*    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static List<String> allowedRoles = List.of("user", "admin");

    private static String getValidRole() {
        while (true) {
                System.out.print("Enter your role " + allowedRoles + ": ");
                String role = scanner.next();
                if (allowedRoles.contains(role.toLowerCase())) {
                    return role;
                }
                System.out.println("Role has to be one of: " + allowedRoles);
        }
    }

    public static boolean signUp() {
        // Ask the user to enter the username and password to sign up

        System.out.print("Enter your username (it's your email): ");
        String username = scanner.next();

        System.out.print("Enter your password: ");
        String password = scanner.next();

        String role = getValidRole();

        try {
            ps = getConnection().prepareStatement("INSERT INTO users(username, password, role)" +
                    " VALUES('" + username + "', '" + password + "', '" + role + "')");
            ps.execute();
            return true;
        } catch (SQLException e) {
            //            e.printStackTrace();
            System.out.println("Unable to sign up. Try again.");
            return false;
        }

    }*/

    private static Scanner scanner = new Scanner(System.in); // To receive input
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean signUp() {

        // Prompt the user to enter the values
        System.out.print("Enter a username: ");
        String username = scanner.next();

        System.out.print("Enter a password");
        String password = scanner.next();

        System.out.print("Enter a role(user, admin): ");
        String role = scanner.next();

        if (role.equalsIgnoreCase("user") || role.equalsIgnoreCase("admin")) {
            try {
                // INSERT INTO users(username, password, role) VALUES('username', 'password', 'role');
                ps = getConnection().prepareStatement(
                        "INSERT INTO users(username, password, role) VALUES('" + username + "', '" + password + "', '" + role + "')");
                ps.execute();
                return true;
            } catch (SQLException e) {
                System.out.println("Username is probably used already. Try another one.");
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("The " + role + " role is invalid. Accepted values are shown in the prompt.");
            return false;
        }

    }

    // Create a login() method like we discussed for the Auth class that returns a Boolean for
    // when a username and password that exists in the database is entered.

    public static boolean login() {
        // Prompt the user to enter the values
        System.out.print("Enter your username to login: ");
        String username = scanner.next();

        System.out.print("Enter your password");
        String password = scanner.next();


        try {
            ps = getConnection().prepareStatement("SELECT * FROM users WHERE username='" + username +
                    "' AND password='" + password + "')");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}




