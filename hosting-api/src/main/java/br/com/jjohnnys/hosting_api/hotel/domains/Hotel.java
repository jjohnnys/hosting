package br.com.jjohnnys.hosting_api.hotel.domains;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String telephone;
    private String email;
    private String ein;  
    @OneToOne  
    private Address address;

    

    public Hotel(UUID id, String name, String telephone, String email, String ein, Address address) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;    
        this.email = email;
        this.ein = ein;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }
    
    public String getTelephone() {
        return telephone;
    }


    public String getEmail() {
        return email;
    }


    public String getEin() {
        return ein;
    }


    public Address getAddress() {
        return address;
    }
    
}
