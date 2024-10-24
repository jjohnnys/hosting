package br.com.jjohnnys.hosting_api.hotel.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String state;
    private String Neighborhood;
    private String publicPlace;
    private String street;
    private String number;
    private String streetCode;


    public Address(Long id, String country, String state, String neighborhood, String publicPlace, String street,
            String number, String streetCode) {
        this.id = id;
        this.country = country;
        this.state = state;
        Neighborhood = neighborhood;
        this.publicPlace = publicPlace;
        this.street = street;
        this.number = number;
        this.streetCode = streetCode;
    }


    public Long getId() {
        return id;
    }


    public String getCountry() {
        return country;
    }


    public String getState() {
        return state;
    }


    public String getNeighborhood() {
        return Neighborhood;
    }


    public String getPublicPlace() {
        return publicPlace;
    }


    public String getStreet() {
        return street;
    }


    public String getNumber() {
        return number;
    }


    public String getStreetCode() {
        return streetCode;
    }
}
