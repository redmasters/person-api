package io.red.personapi.mocks;

import io.red.personapi.models.Address;

public class AddressMock {

    public static Address createAddress(){
        return new Address(
                1L,
                "Street",
                "3558565",
                "Number",
                "City"
        );
    }
}
