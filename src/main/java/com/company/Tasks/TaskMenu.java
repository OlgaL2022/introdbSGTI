package com.company.Tasks;

import java.util.Scanner;

import static com.company.Tasks.TaskController.*;

public class TaskMenu {
    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?: ");
        System.out.println("1. Sign up");
        System.out.println("2. Login");
        System.out.println("3. Add new task");
        System.out.println("4. Edit task");
        System.out.println("5. Delete task");
        System.out.println("6. Get task by id");
        System.out.println("7. Show pending tasks");

        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                TaskController.signUp();
                break;
            case 2:
                TaskController.login();
                break;
            case 3:
                System.out.println(TaskController.addTask() ? "Successfully added new task" : "Task not added");
                break;
            case 4:
                TaskController.editTask();
                break;
            case 5:
                TaskController.deleteTask();
                break;
            case 6:
                System.out.println(getTask());
                break;
            case 7:
                printPendingTasks(getPendingTasks());
                break;
            default:
                System.out.println("Invalid option. Try again");
                menu();
        }

    }
}
