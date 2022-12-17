package main.Exceptions;

public class InvalidResourceTransactionException extends Exception{
    public InvalidResourceTransactionException(String errorMessage) {
       super(errorMessage);
    }
}
