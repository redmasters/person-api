package io.red.personapi.controllers.responses;

public record AddressResponse(
        Long personID,
        Long addressID,
        String street,
        String postalCode,
        String number,
        String city

) {
}
