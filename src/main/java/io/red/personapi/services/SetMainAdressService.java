package io.red.personapi.services;

import io.red.personapi.controllers.requests.MainAddressRequest;
import io.red.personapi.controllers.responses.AddressResponse;
import io.red.personapi.models.Address;
import io.red.personapi.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class SetMainAdressService implements MainAddressInterface {
    private final AddressRepository addressRepository;

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

                        addressRepository.save(address);
                    }
                }
        );


    }
}
