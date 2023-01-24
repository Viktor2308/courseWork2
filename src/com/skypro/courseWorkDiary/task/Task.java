package com.skypro.courseWorkDiary.task;

import com.skypro.courseWorkDiary.repeatTask.Repeat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task implements Repeat {
    private final int id;
    private String name;
    private String description;
    private boolean workTask; //false - home
    private final LocalDateTime dateCreate;
    private int typeRepeat; // 0 - one-time, 1 - daily, 2 - weekly, 3 - monthly, 4 - annual.
    private final List<LocalDate> taskDateRepeat;
    private boolean taskIsActive;
    private static int count;

    public Task(String name, String description, int workTask, int typeRepeat) {
        count++;
        this.id = count;
        setName(name);
        setDescription(description);
        setWorkTask(workTask);
        this.dateCreate = LocalDateTime.now();
        setTypeRepeat(typeRepeat);
        this.taskDateRepeat = new ArrayList<>();
        Repeat.repeat(this.typeRepeat, taskDateRepeat);
        this.taskIsActive = true;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Incorrect information in the name.");
        } else {
            this.name = name;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.isEmpty()) {
            throw new IllegalArgumentException("Incorrect information in the description.");
        } else {
            this.description = description;
        }
    }

    public boolean isWorkTask() {
        return workTask;
    }

    public void setWorkTask(int num) {
        switch (num) {
            case 0:
                workTask = false;
                break;
            case 1:
                workTask = true;
                break;
            default:
                throw new IllegalArgumentException("Incorrect information in work task.");
        }

    }

    public int getTypeRepeat() {
        return typeRepeat;
    }

    public void setTypeRepeat(int typeRepeat) {
        if (typeRepeat < 0 || typeRepeat > 4) {
            throw new IllegalArgumentException("Incorrect information in the type repeat.");
        } else {
            this.typeRepeat = typeRepeat;
        }
    }

    public List<LocalDate> getTaskDateRepeat() {
        return taskDateRepeat;
    }

    public boolean isTaskIsActive() {
        return taskIsActive;
    }

    public void setTaskIsActive(boolean taskIsActive) {
        this.taskIsActive = taskIsActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(dateCreate, task.dateCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, dateCreate);
    }

    @Override
    public String toString() {
        return "Id " + id +
                ", name " + name +
                ", description " + description +
                ", date create " + dateCreate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    }
}
