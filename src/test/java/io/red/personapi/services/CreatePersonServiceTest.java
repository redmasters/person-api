package io.red.personapi.services;

import io.red.personapi.PersonRepository;
import io.red.personapi.mocks.PersonMock;
import io.red.personapi.models.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreatePersonServiceTest {
    @Mock
    PersonRepository repository;
    @InjectMocks
    CreatePersonService createPersonService;

    @Test
    @DisplayName("Should create a person")
    void shouldCreateAPerson() {
        var person = PersonMock.createOnlyName();
        var request = PersonMock.request();
        when(repository.save(any(Person.class)))
                .thenReturn(person);
        createPersonService.create(request);

        assertThat(createPersonService.create(request))
                .isEqualTo(person.toResponse());

    }
}