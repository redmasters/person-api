package io.red.personapi.services;

import io.red.personapi.controllers.requests.PersonRequest;
import io.red.personapi.exceptions.PersonException;
import io.red.personapi.models.Person;
import io.red.personapi.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class UpdatePersonService {
    private final PersonRepository personRepository;

    public UpdatePersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public void updatePerson(PersonRequest request, Long id) {
        var personToUpdate = personRepository.findById(id)
                .orElseThrow(PersonException::new);

        final var updatedPerson = new Person(
                personToUpdate.getId(),
                request.name(),
                Date.valueOf(request.birthDate())
                );

        personRepository.save(updatedPerson);
    }
}
