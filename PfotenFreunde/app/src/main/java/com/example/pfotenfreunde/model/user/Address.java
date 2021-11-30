package com.example.pfotenfreunde.model.user;

public class Address {
    private String street;
    private String zip;
    private String country;

    public Address(String street, String zip, String country) {
        this.street = street;
        this.zip = zip;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
