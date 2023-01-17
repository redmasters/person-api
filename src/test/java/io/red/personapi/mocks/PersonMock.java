package io.red.personapi.mocks;

import io.red.personapi.controllers.requests.PersonRequest;
import io.red.personapi.models.Person;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class PersonMock {

    public static Person createPerson() {
        return new Person(
                1L,
                "Doe",
                Date.from(Instant.now()),
                List.of(AddressMock.createAddress())
        );
    }

    public static Person createOnlyName() {
        return new Person(
                "Doe"
        );
    }

    public static PersonRequest request(){
        return new PersonRequest(
                "Doe",
                "2021-01-01",
                List.of(AddressMock.createAddressRequest())
        );
    }


}
