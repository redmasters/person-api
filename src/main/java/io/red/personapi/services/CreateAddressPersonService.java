package io.red.personapi.services;

import io.red.personapi.controllers.requests.AddressRequest;
import io.red.personapi.controllers.responses.AddressResponse;
import io.red.personapi.exceptions.PersonException;
import io.red.personapi.models.Address;
import io.red.personapi.models.Person;
import io.red.personapi.repositories.AddressRepository;
import io.red.personapi.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateAddressPersonService {
    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    public CreateAddressPersonService(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }

    public ArrayList<AddressResponse> createAdress(List<AddressRequest> request, Long personId) {
        var addressList = new ArrayList<Address>();
        var person = personRepository.findById(personId)
                .orElseThrow(() -> new PersonException());
        var addressResponseList = new ArrayList<AddressResponse>();

        saveAddressUpdatePerson(request, addressList, person);


        addressList.forEach(address ->
                addressResponseList.add(new AddressResponse(
                        person.getId(),
                        address.getId(),
                        address.getStreet(),
                        address.getPostalCode(),
                        address.getNumber(),
                        address.getCity()
                ))
        );

        return addressResponseList;

    }

    private void saveAddressUpdatePerson(List<AddressRequest> request, ArrayList<Address> addressList, Person person) {
        request.forEach(address ->
                addressList.add(
                        addressRepository.save(new Address(
                                address.street(),
                                address.postalCode(),
                                address.number(),
                                address.city()
                        ))));

        final var personAddressUpdated = new Person(
                person.getId(),
                person.getName(),
                person.getBirthDate(),
                addressList
        );
        personRepository.save(personAddressUpdated);
    }

}
