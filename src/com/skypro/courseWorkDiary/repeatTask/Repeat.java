package com.skypro.courseWorkDiary.repeatTask;

import java.time.LocalDate;
import java.util.List;

public interface Repeat {

    static void repeat(int num, List<LocalDate> localDates) {
        switch (num) {
            case 0:
                localDates.add(LocalDate.now());
                break;
            case 1:
                for (int i = 0; i < 3 * 365; i++) {
                    localDates.add(LocalDate.now().plusDays(i));
                }

                break;
            case 2:
                for (int i = 0; i < 3 * 53; i++) {
                    localDates.add(LocalDate.now().plusWeeks(i));
                }
                break;
            case 3:
                for (int i = 0; i < 3 * 12; i++) {
                    localDates.add(LocalDate.now().plusMonths(i));
                }
                break;
            case 4:
                for (int i = 0; i < 3; i++) {
                    localDates.add(LocalDate.now().plusYears(i));
                }
                break;
            default:
                throw new IllegalArgumentException("Incorrect information in void repeat.");
        }
    }
}
