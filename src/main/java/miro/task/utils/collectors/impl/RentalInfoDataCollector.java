package miro.task.utils.collectors.impl;

import miro.task.exceptions.InvalidActualReturnDateException;
import miro.task.exceptions.InvalidReservationEndDateException;
import miro.task.exceptions.InvalidReservationStartDateException;
import miro.task.exceptions.SameDateReturnException;
import miro.task.models.rental.RentalInfo;
import miro.task.utils.collectors.DataCollector;
import miro.task.utils.processors.DateProcessor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Class responsible for collecting rental information from the console.
 * Implements the DataCollector interface for RentalInfo type.
 */
public class RentalInfoDataCollector implements DataCollector<RentalInfo> {

    // Scanner instance for reading user input
    private final Scanner scanner;
    // Date format used for parsing and formatting dates
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Constructor to initialize the scanner.
     *
     * @param scanner Scanner instance for reading user input.
     */
    public RentalInfoDataCollector(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Collects rental information from the user.
     * This includes reservation start date, reservation end date, and actual return date.
     * Validates each date as it is entered.
     *
     * @return A RentalInfo instance containing the collected rental information.
     */
    @Override
    public RentalInfo collect() {
        Date reservationStartDate = collectReservationStartDate();
        Date reservationEndDate = collectReservationEndDate(reservationStartDate);
        Date actualReturnDate = collectActualReturnDate(reservationStartDate);

        long reservedRentalDays = calculateDaysBetween(reservationStartDate, reservationEndDate);
        long actualRentalDays = calculateDaysBetween(reservationStartDate, actualReturnDate);

        return new RentalInfo(Math.toIntExact(reservedRentalDays), Math.toIntExact(actualRentalDays), reservationStartDate, reservationEndDate, actualReturnDate);
    }

    /**
     * Collects and validates the reservation start date from the user.
     *
     * @return A valid reservation start date.
     */
    private Date collectReservationStartDate() {
        while (true) {
            try {
                System.out.print("Enter reservation start date (yyyy-MM-dd): ");
                Date date = DATE_FORMAT.parse(scanner.nextLine());
                DateProcessor.validateReservationStartDate(date);
                return date; // Return date if valid
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            } catch (InvalidReservationStartDateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Collects and validates the reservation end date from the user.
     *
     * @param reservationStartDate The start date of the reservation to compare against.
     * @return A valid reservation end date.
     */
    private Date collectReservationEndDate(Date reservationStartDate) {
        while (true) {
            try {
                System.out.print("Enter reservation end date (yyyy-MM-dd): ");
                Date date = DATE_FORMAT.parse(scanner.nextLine());
                DateProcessor.validateReservationEndDate(reservationStartDate, date);
                return date; // Return date if valid
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            } catch (InvalidReservationEndDateException | SameDateReturnException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Collects and validates the actual return date from the user.
     *
     * @param reservationStartDate The start date of the reservation to compare against.
     * @return A valid actual return date.
     */
    private Date collectActualReturnDate(Date reservationStartDate) {
        while (true) {
            try {
                System.out.print("Enter actual return date (yyyy-MM-dd): ");
                Date date = DATE_FORMAT.parse(scanner.nextLine());
                DateProcessor.validateActualReturnDate(reservationStartDate, date);
                return date; // Return date if valid
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            } catch (InvalidActualReturnDateException | SameDateReturnException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Calculates the number of days between two dates.
     *
     * @param startDate The start date.
     * @param endDate The end date.
     * @return The number of days between startDate and endDate.
     */
    private long calculateDaysBetween(Date startDate, Date endDate) {
        return (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);
    }
}
