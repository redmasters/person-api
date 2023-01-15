package io.red.personapi.services;

import io.red.personapi.controllers.requests.PersonRequest;
import io.red.personapi.models.Address;
import io.red.personapi.models.Person;
import io.red.personapi.repositories.AddressRepository;
import io.red.personapi.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreatePersonService {
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public CreatePersonService(PersonRepository personRepository,
                               AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public Person create(PersonRequest request) {
        final var namePerson = request.name();
        final var birthDate = Date.valueOf(request.birthDate());

        List<Address> addressList = new ArrayList<>();
        request.address().forEach(address ->
                addressList.add(new Address(
                        address.street(),
                        address.postalCode(),
                        address.number(),
                        address.city()
                ))
        );
        addressRepository.saveAll(addressList);

        final var newPerson = new Person(
                namePerson,
                birthDate,
                addressList
        );
        return personRepository.save(newPerson);
    }
}
