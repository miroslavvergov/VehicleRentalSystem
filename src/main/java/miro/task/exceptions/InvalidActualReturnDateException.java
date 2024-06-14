package miro.task.exceptions;

public class InvalidActualReturnDateException extends Exception {

    public InvalidActualReturnDateException() {
        super("Actual return date must be after the reservation start date.");
    }
}
