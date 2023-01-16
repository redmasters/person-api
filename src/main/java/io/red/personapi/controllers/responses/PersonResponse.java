package io.red.personapi.controllers.responses;


import java.util.List;

public record PersonResponse(
        Long id,
        String name,
        String birthDate,
        List<Address> addresses
) {
    public record Address(
            Long id,
            String street,
            String postalCode,
            String number,
            String city
    ){}
}