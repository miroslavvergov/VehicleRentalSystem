package miro.task.utils.formatters;

import java.text.DecimalFormat;

/**
 * Utility class for formatting decimal values.
 */
public class DecimalFormatter {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#0.00");

    /**
     * Formats a double value to a string with two decimal places.
     *
     * @param value The value to format.
     * @return The formatted string.
     */
    public static String format(double value) {
        return DECIMAL_FORMAT.format(value);
    }
}
