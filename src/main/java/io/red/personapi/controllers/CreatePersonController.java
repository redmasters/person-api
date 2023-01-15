package io.red.personapi.controllers;

import io.red.personapi.controllers.requests.PersonRequest;
import io.red.personapi.controllers.responses.PersonResponse;
import io.red.personapi.services.CreatePersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/person")
public class CreatePersonController {

    private final CreatePersonService service;

    public CreatePersonController(CreatePersonService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponse create(@RequestBody PersonRequest request) {
        return service.create(request)
                .toResponse();
    }
}
