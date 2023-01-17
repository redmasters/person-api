package io.red.personapi.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;
    @Column(name = "address_street")
    private String street;
    @Column(name = "address_postal_code")
    private String postalCode;
    @Column(name = "address_number")
    private String number;
    @Column(name = "address_city")
    private String city;
    @Column(name = "address_main")
    private boolean isMain = true;

    public Address() {
    }

    public Address(Long id, String street, String postalCode, String number, String city) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.number = number;
        this.city = city;
    }



    public Address(String street, String postalCode, String number, String city) {
        this.street = street;
        this.postalCode = postalCode;
        this.number = number;
        this.city = city;
    }

    public Address(String street, String postalCode, String number, String city, boolean isMain) {
        this.street = street;
        this.postalCode = postalCode;
        this.number = number;
        this.city = city;
        this.isMain = isMain;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }
}
