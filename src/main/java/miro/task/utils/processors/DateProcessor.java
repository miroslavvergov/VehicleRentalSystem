package miro.task.utils;

import java.util.Date;

public class DateProcessor {

    public static Date addDaysToDate(Date date, int days) {
        long millisToAdd = days * 24 * 60 * 60 * 1000L; // Convert days to milliseconds
        return new Date(date.getTime() + millisToAdd);
    }
}
