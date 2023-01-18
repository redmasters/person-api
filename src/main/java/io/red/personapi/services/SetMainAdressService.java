package io.red.personapi.services;

import io.red.personapi.controllers.requests.MainAddressRequest;
import io.red.personapi.repositories.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SetMainAdressService implements MainAddressInterface {
    private final AddressRepository addressRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(SetMainAdressService.class);

    public SetMainAdressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void setMainAddress(MainAddressRequest request) {
        var addresses = addressRepository
                .findAllByPersonId(request.personId());

        addresses.forEach(address -> {
                    if (address.isMain() && address.getPersonId().equals(request.personId())) {
                        address.setMain(false);
                        addressRepository.save(address);
                    }
                    if (address.getAddressId().equals(request.addressId())) {
                        address.setMain(true);


                        LOGGER.info("Main address ID: {} is now set", address.getAddressId());
                        addressRepository.save(address);
                    }
                }
        );


    }
}
