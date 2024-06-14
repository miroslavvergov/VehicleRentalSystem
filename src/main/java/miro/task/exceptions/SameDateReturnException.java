package miro.task.exceptions;

/**
 * Custom exception for handling cases where two dates are the same when they should not be.
 */
public class SameDateReturnException extends Exception {

    public SameDateReturnException(String message) {
        super(message);
    }

}