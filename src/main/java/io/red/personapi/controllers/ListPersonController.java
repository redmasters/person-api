package io.red.personapi.controllers;

import io.red.personapi.controllers.responses.PersonResponse;
import io.red.personapi.services.ListPersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/person")
public class ListPersonController {

    private final ListPersonService service;

    public ListPersonController(ListPersonService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<PersonResponse> listAll(Pageable page) {
        return service.listAllPersons(page);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonResponse listById(@PathVariable(name = "id") Long id) {
        return service.listById(id);
    }
}
