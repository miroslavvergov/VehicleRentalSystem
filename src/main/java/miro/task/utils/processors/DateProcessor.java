package miro.task.utils.processors;

import miro.task.exceptions.InvalidActualReturnDateException;
import miro.task.exceptions.InvalidReservationEndDateException;
import miro.task.exceptions.InvalidReservationStartDateException;
import miro.task.exceptions.SameDateReturnException;

import java.util.Date;

/**
 * DateProcessor is a utility class that provides date manipulation functions.
 *
 * <p>This class includes methods for performing operations on Date objects,
 * such as adding a specified number of days to a given date and obtaining the current date.
 *
 * <p>Usage example:
 * <pre>{@code
 * Date originalDate = new Date();
 * Date newDate = DateProcessor.addDaysToDate(originalDate, 5);
 * Date currentDate = DateProcessor.getCurrentDate();
 * }</pre>
 *
 * <p>Thread Safety: This class is thread-safe since it does not maintain any
 * state and only operates on the provided input parameters.
 */
public class DateProcessor {

    /**
     * Adds a specified number of days to the given date.
     *
     * <p>This method calculates the number of milliseconds to add based on the
     * provided number of days, converts that to milliseconds, and creates a new
     * Date object with the updated time.
     *
     * @param date the original date to which days will be added. Must not be null.
     * @param days the number of days to add to the date. Can be negative to subtract days.
     * @return a new Date object that represents the original date plus the specified
     * number of days.
     * @throws IllegalArgumentException if the date parameter is null.
     */
    public static Date addDaysToDate(Date date, int days) {
        if (date == null) {
            throw new IllegalArgumentException("The date parameter must not be null");
        }
        long millisToAdd = days * 24L * 60 * 60 * 1000; // Convert days to milliseconds
        return new Date(date.getTime() + millisToAdd);
    }

    /**
     * Gets the current date and time.
     *
     * <p>This method creates and returns a new Date object representing the
     * current date and time at the moment the method is called.
     *
     * @return a new Date object representing the current date and time.
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    public static void validateReservationStartDate(Date startDate) throws InvalidReservationStartDateException {
        Date today = new Date();

        if (!(startDate.getDay() >= today.getDay())) {
            throw new InvalidReservationStartDateException();
        }
    }

    public static void validateReservationEndDate(Date startDate, Date endDate) throws InvalidReservationEndDateException, SameDateReturnException {
        if (endDate.before(startDate)) {
            throw new InvalidReservationEndDateException();
        }
        if (endDate.equals(startDate)) {
            throw new SameDateReturnException("Reservation end date cannot be the same as reservation start date.");
        }
    }

    public static void validateActualReturnDate(Date startDate, Date returnDate) throws InvalidActualReturnDateException, SameDateReturnException {
        if (returnDate.before(startDate)) {
            throw new InvalidActualReturnDateException();
        }
        if (returnDate.equals(startDate)) {
            throw new SameDateReturnException("Actual return date cannot be the same as reservation start date.");
        }
    }

}
