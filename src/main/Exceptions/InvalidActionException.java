package main.Exceptions;

/**
 * Error that is thrown when an action is passed through to a handler not designed for the given action
 * etc Card A is given a blueAction to perform that belongs to card B
 */
public class InvalidActionException extends Exception{
    public InvalidActionException(String errorMessage) {
        super(errorMessage);
    }
}
