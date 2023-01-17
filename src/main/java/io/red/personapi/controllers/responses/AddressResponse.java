package io.red.personapi.controllers.responses;

public record AddressResponse(
        Long personID,
        String street,
        String postalCode,
        String number,
        String city,
        boolean mainAdress

) {
}
