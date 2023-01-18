package io.red.personapi.exceptions;

public class AddressException extends RuntimeException{
    public AddressException() {
        super("Adress not found");
    }
}
