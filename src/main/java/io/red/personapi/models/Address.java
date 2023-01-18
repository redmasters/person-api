package io.red.personapi.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;
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
    @Column(name = "fktbl_personaddress_id")
    private Long personId;


    public Address() {
    }

    public Address(Long addressId, String street, String postalCode, String number, String city) {
        this.addressId = addressId;
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

    public Address(String street, String postalCode, String number, String city, boolean isMain, Long personId) {
        this.street = street;
        this.postalCode = postalCode;
        this.number = number;
        this.city = city;
        this.isMain = isMain;
        this.personId = personId;
    }

    public Long getAddressId() {
        return addressId;
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

    public Long getPersonId() {
        return personId;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }
}
