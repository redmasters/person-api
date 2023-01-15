package io.red.personapi.models;

import io.red.personapi.controllers.responses.PersonResponse;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "tbl_person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "person_id")
    private Long id;
    @Column(name = "person_name")
    private String name;
    @Column(name = "person_birth_date")
    private Date birthDate;

    @OneToMany(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "fktbl_personaddress_id")
    private List<Address> address;

    public Person() {
    }

    public Person(Long id, String name, Date birthDate, List<Address> address) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }

    public Person(Long id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Person(String name, Date birthDate, List<Address> address) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }

    public Person(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<Address> getAddress() {
        return address;
    }

    public PersonResponse toResponse() {
        return new PersonResponse(
                this.name
        );
    }
}
