package io.red.personapi.controllers.requests;

import java.util.List;

public record AddressDataRequest(
        Long personId,
        List<AddressRequest> addressList
) {
}
