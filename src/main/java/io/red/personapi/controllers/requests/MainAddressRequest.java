package io.red.personapi.controllers.requests;

public record MainAddressRequest(
        Long personId,
        Long addressId
) {
}
