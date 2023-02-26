package com.skypro.courseWorkDiary.serviceTask;

import com.skypro.courseWorkDiary.exeption.TaskNotFoundException;
import com.skypro.courseWorkDiary.task.Task;


import java.time.LocalDate;
import java.util.*;

public class ServiceTask {
    private ServiceTask() {
    }

    private static final HashMap<Integer, Task> taskHashMap = new HashMap<>();
    private static final List<Task> delTaskArrayList = new ArrayList<>();

    public static void addTaskMap(Task task) {
        taskHashMap.put(task.getId(), task);
    }


    public static void delTask(int id) {
        if (taskHashMap.containsKey(id)) {
            delTaskArrayList.add(taskHashMap.get(id));
            taskHashMap.remove(id);
        } else {
            System.out.println("Task with this id was not found.");
        }
    }

    public static ArrayList<Task> getAllByDay(LocalDate localDate) throws TaskNotFoundException {
        ArrayList<Task> taskArrayList = new ArrayList<>();
        for (Task task : taskHashMap.values()) {
            if (task.appearsIn(localDate))
                taskArrayList.add(task);
        }
        if (!taskArrayList.isEmpty()) {
            return taskArrayList;
        } else {
            System.out.println("No Task in this date.");
            return null;
        }

    }

    public static void printAllDellTask() {
        for (Task task : delTaskArrayList) {
            System.out.println(task);
        }
    }


}
