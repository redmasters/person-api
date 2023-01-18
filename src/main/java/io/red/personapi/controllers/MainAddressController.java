package io.red.personapi.controllers;

import io.red.personapi.controllers.requests.MainAddressRequest;
import io.red.personapi.services.SetMainAdressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/person")
public class MainAddressController {
    private final SetMainAdressService service;

    public MainAddressController(SetMainAdressService service) {
        this.service = service;
    }

    @PutMapping("/main-address")
    @ResponseStatus(HttpStatus.OK)
    public void setMainAddress(@RequestBody MainAddressRequest request) {
        service.setMainAddress(request);
    }
}
