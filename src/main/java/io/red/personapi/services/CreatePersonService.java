package io.red.personapi.services;

import io.red.personapi.PersonRepository;
import io.red.personapi.controllers.requests.PersonRequest;
import io.red.personapi.models.Person;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonService {
    private final PersonRepository repository;

    public CreatePersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(PersonRequest request) {
        final var namePerson = request.name();

        final var newPerson = new Person(
                namePerson
        );
        return repository.save(newPerson);
    }
}
