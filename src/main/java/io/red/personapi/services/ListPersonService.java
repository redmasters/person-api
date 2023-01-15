package io.red.personapi.services;

import io.red.personapi.controllers.responses.PersonResponse;
import io.red.personapi.repositories.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListPersonService {
    private final PersonRepository personRepository;

    public ListPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Page<PersonResponse> listAllPersons(Pageable page) {
        final var personList = personRepository.findAll(page);
        List<PersonResponse> responseList = new ArrayList<>();

        personList.forEach(person -> {
            String birthDate = person.getBirthDate() == null ? "" : person.getBirthDate().toString();
                    List<PersonResponse.Address> addressList = new ArrayList<>();

                    person.getAddress().forEach(address ->
                            addressList.add(new PersonResponse.Address(
                                    address.getId(),
                                    address.getStreet(),
                                    address.getPostalCode(),
                                    address.getNumber(),
                                    address.getCity()
                            ))
                    );

                    responseList.add(
                            new PersonResponse(
                                    person.getId(),
                                    person.getName(),
                                    birthDate,
                                    addressList
                                    )
                    );
                }
        );

        return new PageImpl<>(responseList, page, personList.getSize());

    }
}
