package main.Exceptions;

public class InvalidPlayerTransactionException extends Exception{
    public InvalidPlayerTransactionException(String errorMessage) {
       super(errorMessage);
    }
}
