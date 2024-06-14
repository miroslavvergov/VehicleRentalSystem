package miro.task.exceptions;

public class InvalidReservationEndDateException extends Exception {

    public InvalidReservationEndDateException() {
        super("Reservation end date must be after the reservation start date.");
    }
}
