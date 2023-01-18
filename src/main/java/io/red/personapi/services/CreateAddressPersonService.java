package io.red.personapi.services;

import io.red.personapi.controllers.requests.AddressDataRequest;
import io.red.personapi.controllers.responses.AddressResponse;
import io.red.personapi.exceptions.PersonException;
import io.red.personapi.models.Address;
import io.red.personapi.repositories.AddressRepository;
import io.red.personapi.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateAddressPersonService {
    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
    private final static Logger LOGGER = LoggerFactory.getLogger(CreateAddressPersonService.class);

    public CreateAddressPersonService(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }

    public List<AddressResponse> createAdress(AddressDataRequest request) {

        List<Address> addressModelList = new ArrayList<>();
        List<AddressResponse> responseList = new ArrayList<>();

        LOGGER.info("Saving {} address(es)", request.addressList().size());
        request.addressList().forEach(address -> {
            var person = personRepository.findById(request.personId())
                    .orElseThrow(PersonException::new);

            var addressModel = new Address(
                    address.street(),
                    address.postalCode(),
                    address.number(),
                    address.city(),
                    address.mainAddress(),
                    person.getPersonId()
            );

            LOGGER.info("Address set for {}", person.getName());

            addressModelList.add(addressModel);
            responseList.add(new AddressResponse(
                    addressModel.getPersonId(),
                    addressModel.getStreet(),
                    addressModel.getPostalCode(),
                    addressModel.getNumber(),
                    addressModel.getCity(),
                    addressModel.isMain()
            ));
        });

        LOGGER.info("{} address(es) saved", addressModelList.size());
        addressRepository.saveAll(addressModelList);

        return responseList;
    }

}
