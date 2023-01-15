package io.red.personapi.controllers;

import io.red.personapi.controllers.responses.PersonResponse;
import io.red.personapi.services.ListPersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/person")
public class ListPersonController {

    private final ListPersonService service;

    public ListPersonController(ListPersonService service) {
        this.service = service;
    }

    @GetMapping
    public Page<PersonResponse> listAll(Pageable page) {
        return service.listAllPersons(page);
    }
}
