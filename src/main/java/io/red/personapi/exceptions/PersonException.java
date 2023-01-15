package io.red.personapi.exceptions;

public class PersonException extends RuntimeException{
    public PersonException() {
        super("Person not found");
    }
}
