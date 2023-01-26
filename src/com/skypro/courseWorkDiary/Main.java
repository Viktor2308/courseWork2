package com.skypro.courseWorkDiary;


import com.skypro.courseWorkDiary.exeption.IncorrectArgumentException;
import com.skypro.courseWorkDiary.exeption.TaskNotFoundException;
import com.skypro.courseWorkDiary.task.*;

import java.time.LocalDate;
import java.util.Scanner;

import static com.skypro.courseWorkDiary.serviceTask.ServiceTask.*;

public class Main {
    public static void main(String[] args) throws IncorrectArgumentException, TaskNotFoundException {
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
                    System.out.println("Select a menu item from the list!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) throws IncorrectArgumentException {
        System.out.print("Enter task name: ");
        String taskName = scanner.next();
        System.out.print("Enter task description: ");
        String taskDescription = scanner.next();
        System.out.print("Enter type task : (home/work) ");
        String taskType = scanner.next();
        printTaskRepeat();
        System.out.print("Enter the task recurrence type: ");
        int TaskRepeat = scanner.nextInt();
        switch (TaskRepeat) {
            case 1:
                try {
                    addTaskMap(new OneTimeTask(taskName,taskDescription,taskType));
                    break;
                } catch (IncorrectArgumentException e) {
                    throw new IncorrectArgumentException("No correct argument.");
                }
            case 2:
                try {
                    addTaskMap(new DailyTask(taskName,taskDescription,taskType));
                    break;
                } catch (IncorrectArgumentException e) {
                    throw new IncorrectArgumentException("No correct argument.");
                }
            case 3:
                try {
                    addTaskMap(new WeeklyTask(taskName,taskDescription,taskType));
                    break;
                } catch (IncorrectArgumentException e) {
                    throw new IncorrectArgumentException("No correct argument.");
                }
            case 4:
                try {
                    addTaskMap(new MonthlyTask(taskName,taskDescription,taskType));
                    break;
                } catch (IncorrectArgumentException e) {
                    throw new IncorrectArgumentException("No correct argument.");
                }
            case 5:
                try {
                    addTaskMap(new YearlyTask(taskName,taskDescription,taskType));
                    break;
                } catch (IncorrectArgumentException e) {
                    throw new IncorrectArgumentException("No correct argument.");
                }
            default:
                break;

        }
    }



    private static void outputTask(Scanner scanner) throws TaskNotFoundException {
        System.out.print("Enter date, year: ");
        int year = scanner.nextInt();
        System.out.print("Enter date, month: ");
        int month = scanner.nextInt();
        System.out.print("Enter date, day: ");
        int day = scanner.nextInt();
        System.out.println(getAllByDay(LocalDate.of(year, month, day)));

    }

    private static void dellTask(Scanner scanner) throws TaskNotFoundException {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        delTask(id);

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

    private static void printTaskRepeat() {
        System.out.println(
                "\n1. one-time " +
                "\n2. daily " +
                "\n3. weekly " +
                "\n4. monthly " +
                "\n5. yearly "
        );
    }
}
