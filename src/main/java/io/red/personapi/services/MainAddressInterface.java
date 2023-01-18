package io.red.personapi.services;

import io.red.personapi.controllers.requests.MainAddressRequest;

public interface MainAddressInterface<T> {

    void setMainAddress(MainAddressRequest request);
}
