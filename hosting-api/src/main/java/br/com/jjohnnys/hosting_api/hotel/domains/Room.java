package br.com.jjohnnys.hosting_api.hotel.domains;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private Float area;
    private String Status;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private Capacity capacity;
    @ElementCollection
    @JoinTable(
            name = "room_room_item",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "room_item_id")
    )
    private Set<RoomItem> roomItems;

    public Room(UUID id, String description, Float area, String status, Hotel hotel, Capacity capacity, Set<RoomItem> roomItems) {
        this.id = id;
        this.description = description;
        this.area = area;
        Status = status;
        this.hotel = hotel;
        this.capacity = capacity;
        this.roomItems = roomItems;
    }


    public UUID getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }


    public Float getArea() {
        return area;
    }


    public String getStatus() {
        return Status;
    }


    public Hotel getHotel() {
        return hotel;
    }


    public Set<RoomItem> getRoomItems() {
        return roomItems;
    }


    public Capacity getCapacity() {
        return capacity;
    }

    
    
}
