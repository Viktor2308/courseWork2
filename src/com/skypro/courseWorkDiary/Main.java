package com.skypro.courseWorkDiary;

import com.skypro.courseWorkDiary.serviceTask.ServiceTask;
import com.skypro.courseWorkDiary.task.Task;

import java.util.Scanner;

import static com.skypro.courseWorkDiary.serviceTask.ServiceTask.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Select a menu item: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            dellTask(scanner);
                            break;
                        case 3:
                            outputTask(scanner);
                            break;
                        case 4:
                            getAllDellTask();
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        System.out.print("Enter task name: ");
        String taskName = scanner.next();
        System.out.print("Enter task description: ");
        String taskDescription = scanner.next();
        System.out.print("Enter task type (0 - Home / 1 - work) : ");
        int taskType = scanner.nextInt();
        System.out.print("Enter type task repeat (0 - one-time  1 - daily 2 - weekly 3 - monthly 4 - annual): ");
        int inputTaskRepeat = scanner.nextInt();
        Task task = new Task(
                taskName,
                taskDescription,
                taskType,
                inputTaskRepeat);
        System.out.println(task);
        addTaskMap(task);
    }

    private static void outputTask(Scanner scanner) {
        System.out.print("Enter date, year: ");
        int year = scanner.nextInt();
        System.out.print("month: ");
        int month = scanner.nextInt();
        System.out.print("day: ");
        int day = scanner.nextInt();

        getTasksForDay(year, month, day);
    }

    private static void dellTask(Scanner scanner) {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        ServiceTask.dellTask(id);
    }

    private static void getAllDellTask() {
        printAllDellTask();
    }

    private static void printMenu() {
        System.out.println("1. Add task in diary " +
                "\n2. Delete task " +
                "\n3. Get a task for a specified day " +
                "\n4. Get a all dell task " +
                "\n0. Exit"
        );
    }
}
