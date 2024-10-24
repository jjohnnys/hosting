package br.com.jjohnnys.hosting_api.hotel.domains;

import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class RoomItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String item;
    private String description;
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<Room> roomns;

   
    public RoomItem(Integer id, String item, String description, Set<Room> roomns) {
        this.id = id;
        this.item = item;
        this.description = description;
        this.roomns = roomns;
    }


    public Integer getId() {
        return id;
    }


    public String getItem() {
        return item;
    }


    public String getDescription() {
        return description;
    }


    public Set<Room> getRoomns() {
        return roomns;
    }

    



}
