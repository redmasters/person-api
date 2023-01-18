package io.red.personapi.services;

import io.red.personapi.controllers.responses.PersonResponse;
import io.red.personapi.exceptions.PersonException;
import io.red.personapi.models.Person;
import io.red.personapi.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListPersonService {
    private final PersonRepository personRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ListPersonService.class);

    public ListPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Page<PersonResponse> listAllPersons(Pageable page) {
        final var personList = personRepository.findAll(page);

        LOGGER.info("Found {} person(s)", personList.getTotalElements());
        List<PersonResponse> responseList = new ArrayList<>();

        getPaginatedPersonList(personList, responseList);

        return new PageImpl<>(responseList, page, personList.getSize());

    }

    public PersonResponse listById(Long id) {
        final var person = personRepository.findById(id).
                orElseThrow(PersonException::new);
        var addressList = getAddressList(person);

        LOGGER.info("Listing {} info", person.getName());
        return new PersonResponse(
                person.getPersonId(),
                person.getName(),
                person.getBirthDate().toString(),
                addressList
        );
    }

    private static void getPaginatedPersonList(Page<Person> personList, List<PersonResponse> responseList) {
        personList.forEach(person -> {
                    String birthDate = person.getBirthDate() == null ? "" : person.getBirthDate().toString();
                    var addressList = getAddressList(person);

                    responseList.add(
                            new PersonResponse(
                                    person.getPersonId(),
                                    person.getName(),
                                    birthDate,
                                    addressList
                            )
                    );
                }
        );
    }

    private static List<PersonResponse.Address> getAddressList(Person person) {
        List<PersonResponse.Address> addressList = new ArrayList<>();

        person.getAddressList().forEach(address ->
                addressList.add(new PersonResponse.Address(
                        address.getAddressId(),
                        address.getStreet(),
                        address.getPostalCode(),
                        address.getNumber(),
                        address.getCity(),
                        address.isMain()
                ))
        );
        return addressList;
    }
}
