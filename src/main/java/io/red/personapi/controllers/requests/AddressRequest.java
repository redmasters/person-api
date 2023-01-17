package io.red.personapi.controllers.requests;

public record AddressRequest(
        String street,
        String postalCode,
        String number,
        String city,
        boolean mainAdress

) {
}
