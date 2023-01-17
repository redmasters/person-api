package io.red.personapi.controllers;

import io.red.personapi.controllers.requests.AddressRequest;
import io.red.personapi.controllers.responses.AddressResponse;
import io.red.personapi.services.CreateAddressPersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/person")
public class CreateAddressController {

    private final CreateAddressPersonService service;

    public CreateAddressController(CreateAddressPersonService service) {
        this.service = service;
    }

    @PostMapping("/address")
    public ArrayList<AddressResponse> createAddress(List<AddressRequest> request,
                                                    @RequestParam(name = "personId") Long personId) {
        return service.createAdress(request, personId);
    }
}
