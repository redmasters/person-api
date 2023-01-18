package io.red.personapi.services;

import io.red.personapi.mocks.AddressMock;
import io.red.personapi.mocks.PersonMock;
import io.red.personapi.models.Person;
import io.red.personapi.repositories.AddressRepository;
import io.red.personapi.repositories.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreatePersonServiceTest {
    @Mock
    PersonRepository personRepository;
    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    CreatePersonService createPersonService;


    @Test
    @DisplayName("Should create a person")
    void shouldCreateAPerson() {
        final var addressList = List.of(AddressMock.createAddress());

        var person = PersonMock.createPerson();
        var request = PersonMock.request();

        when(addressRepository.saveAll(anyList()))
                .thenReturn(addressList);

        when(personRepository.save(any(Person.class)))
                .thenReturn(person);

        final var personService = createPersonService.create(request);

        Assertions.assertEquals(person, personService);

    }
}