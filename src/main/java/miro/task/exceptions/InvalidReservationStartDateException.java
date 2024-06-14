package miro.task.exceptions;

public class InvalidReservationStartDateException extends Exception {

    public InvalidReservationStartDateException() {
        super("Reservation start date cannot be in the past.");
    }
}

