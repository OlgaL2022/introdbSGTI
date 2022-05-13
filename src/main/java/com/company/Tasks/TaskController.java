package com.company.Tasks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import static com.company.Tasks.DbConnection.getConnection;

public class TaskController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean signUp() {

        // Prompt the user to enter the values
        System.out.print("Enter a username: ");
        String username = scanner.next();

        System.out.print("Enter a password: ");
        String password = scanner.next();
        try {
            ps = getConnection().prepareStatement("INSERT INTO users(username, password) VALUES('" + username + "', '" + password + "')");
            ps.execute();
            System.out.println("Added successfully");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean login() {
        System.out.print("Enter the username: ");
        String name = scanner.next();
        System.out.print("Enter the password: ");
        String password = scanner.next();
        try {
            ps = getConnection().
                    prepareStatement("SELECT * FROM users WHERE username='" + name + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("username").equals(name) && rs.getString("password").equals(password)) {
                    System.out.println("Login successful");
                    return true;
                } else {
                    System.out.println("Username or password is not correct. Try again");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database error");
            return false;
        }
        return false;
    }

    public static boolean addTask() {

        System.out.print("Enter your username: ");
        String username = scanner.next();

        System.out.print("Enter your task: ");
        String task = scanner.next();

        System.out.print("Enter your deadline (yyyy-mm-dd): ");
        String time = scanner.next();
        LocalDate deadline = LocalDate.parse(time);

        System.out.print("Accomplishment (yes or no): ");
        String answer = scanner.next();
        Boolean yn = (answer.equalsIgnoreCase("YES") ? true : false);

        try {
            ps = getConnection().prepareStatement("INSERT INTO todolist(username, task, deadline, acomplishment)"
                    + " VALUES('" + username + "','" + task + "',  '" + deadline + "' , '" + yn + "')");
            ps.execute();
            System.out.println("Added successfully");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void editTask() {
        System.out.print("Enter the task's id: ");
        int id = scanner.nextInt();

        System.out.print("What do you want to edit it to?: ");
        String update = scanner.next();

        try {
            ps = getConnection().prepareStatement("UPDATE todolist SET task ='" + update + "' WHERE id=" + id + ";");
            ps.execute();
            System.out.println("Successfully updated data");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteTask() {
        System.out.print("Enter task's id: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("DELETE FROM todolist WHERE id =" + id);
            ps.execute();
            System.out.println("Deleted successfully");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Task getTask() {
        System.out.print("Enter task's id: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM todolist WHERE id =" + id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Task(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("task"),
                        rs.getDate("deadline"),
                        rs.getBoolean("acomplishment"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Task> getPendingTasks() {

        try {
            ps = getConnection().prepareStatement("SELECT * FROM todolist WHERE deadline > NOW() AND acomplishment is false;");
            rs = ps.executeQuery();

            List<Task> pendingTasks = new ArrayList<>();

            while (rs.next()) {
                pendingTasks.add(new Task(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("task"),
                        rs.getDate("deadline"),
                        rs.getBoolean("acomplishment")
                ));

            }
            return pendingTasks;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }

    public static void printPendingTasks(List<Task> tasks) {
        System.out.println("Pending tasks: ");
        for (Task task : tasks) {
            System.out.printf("Task ID = %s, username = %s, taskname = %s, deadline = %s, acomplishment = %s\n",
                    task.getId(), task.getUsername(), task.getTask(), task.getDeadline(), task.isAcomplishment());
        }
    }
}
