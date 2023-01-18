package io.red.personapi.models;

import io.red.personapi.controllers.responses.PersonResponse;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "tbl_person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "person_name")
    private String name;
    @Column(name = "person_birth_date")
    private Date birthDate;

    @OneToMany(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "fktbl_personaddress_id")
    private List<Address> addressList;

    public Person() {
    }

    public Person(Long personId, String name, Date birthDate, List<Address> addressList) {
        this.personId = personId;
        this.name = name;
        this.birthDate = birthDate;
        this.addressList = addressList;
    }

    public Person(Long personId, String name, Date birthDate) {
        this.personId = personId;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Person(String name, Date birthDate, List<Address> addressList) {
        this.name = name;
        this.birthDate = birthDate;
        this.addressList = addressList;
    }

    public Person(String name) {
        this.name = name;
    }

    public Long getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public PersonResponse toResponse() {
        List<PersonResponse.Address> addresses = new ArrayList<>();
        this.getAddressList().forEach(address ->
                addresses.add(new PersonResponse.Address(
                        address.getAddressId(),
                        address.getStreet(),
                        address.getPostalCode(),
                        address.getNumber(),
                        address.getCity(),
                        address.isMain()

                ))
        );

        return new PersonResponse(
                this.personId,
                this.name,
                this.birthDate.toString(),
                addresses
                );
    }
}
