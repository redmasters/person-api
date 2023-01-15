package io.red.personapi.controllers.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

public record PersonRequest(
        @NotBlank
        String name,
        @NotBlank
        Date birthDate,
        @NotEmpty
        List<Address> address

) {
    public record Address(
            @NotBlank
            String street,
            @NotBlank
            String postalCode,
            @NotBlank
            String number,
            @NotBlank
            String city

    ) {
    }
}
