package com.skypro.courseWorkDiary.task;

import com.skypro.courseWorkDiary.exeption.IncorrectArgumentException;

import java.time.LocalDate;

public class YearlyTask extends Task{
    public YearlyTask(String title, String description, String type) throws IncorrectArgumentException {
        super(title, description, type);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return (date.isAfter(getDateCreate().toLocalDate()) ||
                date.isEqual(getDateCreate().toLocalDate())) &&
                date.getDayOfYear() == getDateCreate().getDayOfYear();
    }
}
