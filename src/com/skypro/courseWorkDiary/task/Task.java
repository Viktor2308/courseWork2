package com.skypro.courseWorkDiary.task;


import com.skypro.courseWorkDiary.exeption.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Objects;

public abstract class Task {
    private final int id;
    private String title;
    private String description;
    private Type type;
    private final LocalDateTime dateCreate;
    private static int count = 0;

    public Task(String title, String description, String type) throws IncorrectArgumentException {
        this.id = count;
        setTitle(title);
        setDescription(description);
        setType(type);
        this.dateCreate = LocalDateTime.now();
        count++;
    }

    public void setType(String type) throws IncorrectArgumentException {
        if (type.equalsIgnoreCase("home")) {
            this.type = Type.HOME;
        } else if (type.equalsIgnoreCase("work")) {
            this.type = Type.WORK;
        } else {
            throw new IncorrectArgumentException("No correct argument in Type task.");
        }
    }


    public void setTitle(String title) throws IncorrectArgumentException {
        if (!title.isEmpty()) {
            this.title = title;
        } else {
            throw new IncorrectArgumentException("No correct argument in Title task.");
        }
    }

    public void setDescription(String description) throws IncorrectArgumentException {
        if (!description.isEmpty()) {
            this.description = description;
        } else {
            throw new IncorrectArgumentException("No correct argument in Description task.");
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public abstract boolean appearsIn(LocalDate date);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description) && type == task.type && Objects.equals(dateCreate, task.dateCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, type, dateCreate);
    }

    @Override
    public String toString() {
        return "id " + id +
                ", " + type +
                ", " + title +
                ", " + description +
                ", " + dateCreate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    }
}