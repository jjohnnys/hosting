package br.com.jjohnnys.hosting_api.hotel.domains;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Capacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int amount;
    @OneToMany
    private Set<Room> roms;


    public Capacity(Integer id, String name, int amount, Set<Room> roms) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.roms = roms;
    }


    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public int getAmount() {
        return amount;
    }


    public Set<Room> getRoms() {
        return roms;
    }

    
        
    

}
