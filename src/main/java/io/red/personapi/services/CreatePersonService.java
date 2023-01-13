package io.red.personapi.services;

import io.red.personapi.PersonRepository;
import io.red.personapi.controllers.requests.PersonRequest;
import io.red.personapi.controllers.responses.PersonResponse;
import io.red.personapi.models.Person;
import org.springframework.stereotype.Service;

@Service
public class CreatePerson {
    private final PersonRepository repository;

    public CreatePerson(PersonRepository repository) {
        this.repository = repository;
    }

    public PersonResponse create(PersonRequest request) {
        Person newPerson = new Person(
                request.name()
        );
        return repository.save(newPerson)
                .toResponse();
    }
}
