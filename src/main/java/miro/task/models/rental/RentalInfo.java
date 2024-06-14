package miro.task.models.rental;

import java.util.Date;

/**
 * Record representing rental information for a vehicle rental transaction.
 * Contains details about the rental period and the dates involved.
 *
 * @param reservedRentalDays   The number of days the vehicle was originally reserved for.
 * @param actualRentalDays     The actual number of days the vehicle was rented.
 * @param reservationStartDate The start date of the reservation.
 * @param reservationEndDate   The end date of the reservation.
 * @param actualReturnDate     The actual date when the vehicle was returned.
 */
public record RentalInfo(int reservedRentalDays,
                         int actualRentalDays,
                         Date reservationStartDate,
                         Date reservationEndDate,
                         Date actualReturnDate) {
}
