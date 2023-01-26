package com.skypro.courseWorkDiary.task;

import com.skypro.courseWorkDiary.exeption.IncorrectArgumentException;

import java.time.LocalDate;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, String description, String type) throws IncorrectArgumentException {
        super(title, description, type);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.isEqual(getDateCreate().toLocalDate());
    }
}
