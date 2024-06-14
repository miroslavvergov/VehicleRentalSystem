package miro.task.utils.formatters;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for formatting date values.
 */
public class DateFormatter {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Formats a date to a string in the format yyyy-MM-dd.
     *
     * @param date The date to format.
     * @return The formatted string.
     */
    public static String format(Date date) {
        return DATE_FORMAT.format(date);
    }
}
