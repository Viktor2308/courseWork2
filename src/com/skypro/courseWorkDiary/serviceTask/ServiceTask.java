package com.skypro.courseWorkDiary.serviceTask;

import com.skypro.courseWorkDiary.task.Task;

import java.time.LocalDate;
import java.util.HashMap;

public abstract class ServiceTask {
    private static final HashMap<Integer, Task> taskHashMap = new HashMap<>();

    public static void addTaskMap(Task task) {
        taskHashMap.put(task.getId(), task);
    }

    public static void getTasksForDay(int year, int month, int day) {
        if (year > 2022 && year < 2123 && month >= 1 && month <= 12 && day >= 1 && day <= 31) {
            LocalDate date = LocalDate.of(year, month, day);
            for (Task task : taskHashMap.values()) {
                if (!task.getTaskDateRepeat().isEmpty() && task.getTaskDateRepeat().contains(date) && task.isTaskIsActive()) {
                    System.out.println(task);
                }
            }
        } else {
            System.out.println("Date enter not correct");
        }
    }


    public static void dellTask(int id) {
        if (id > 0) {
            for (int key : taskHashMap.keySet()) {
                if (id == key) {
                    taskHashMap.get(key).setTaskIsActive(false);
                    System.out.println("Task " + taskHashMap.get(key).getName() + " deleted.");
                    return;
                }
            }
            System.out.println("Task with this id was not found");
        } else {
            System.out.println("Id is not correct.");
        }
    }

    public static void printAllDellTask() {
        for (Task task : taskHashMap.values()) {
            if (!task.isTaskIsActive()) {
                System.out.println(task);
            }
        }

    }

//    public static void printAllDellTask(int year, int month, int day) {
//        if (year > 2022 && year < 2123 && month >= 1 && month <= 12 && day >= 1 && day <= 31) {
//            LocalDate date = LocalDate.of(year, month, day);
//            for (Task task : taskHashMap.values()) {
//                if (!task.isTaskIsActive() && task.getTaskDateRepeat().contains(date)) {
//                    System.out.println(task);
//                }
//            }
//        } else {
//            System.out.println("Date enter not correct");
//        }
//    }

}
