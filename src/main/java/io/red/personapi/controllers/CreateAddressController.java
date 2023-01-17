package io.red.personapi.controllers;

import io.red.personapi.controllers.requests.AddressDataRequest;
import io.red.personapi.controllers.responses.AddressResponse;
import io.red.personapi.services.CreateAddressPersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/person")
public class CreateAddressController {

    private final CreateAddressPersonService service;

    public CreateAddressController(CreateAddressPersonService service) {
        this.service = service;
    }

    @PostMapping("/address")
    public List<AddressResponse> createAddress(@RequestBody @Valid AddressDataRequest request) {
        return service.createAdress(request);
    }
}
