package br.com.jjohnnys.hosting_api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.jjohnnys.hosting_api.hotel.domains.Address;
import br.com.jjohnnys.hosting_api.hotel.domains.Capacity;
import br.com.jjohnnys.hosting_api.hotel.domains.Hotel;
import br.com.jjohnnys.hosting_api.hotel.domains.Room;
import br.com.jjohnnys.hosting_api.hotel.domains.RoomItem;
import br.com.jjohnnys.hosting_api.hotel.reporitory.AddressRepository;
import br.com.jjohnnys.hosting_api.hotel.reporitory.CapacityRepository;
import br.com.jjohnnys.hosting_api.hotel.reporitory.HotelRepository;
import br.com.jjohnnys.hosting_api.hotel.reporitory.RoomItemRepository;
import br.com.jjohnnys.hosting_api.hotel.reporitory.RoomRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CreateHotelERoonsTest {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private CapacityRepository capacityRepository;
    @Autowired
    private RoomItemRepository roomItemRepository;
    @Autowired
    private RoomRepository roomRepository;    


    @Test
    public void createHotelAndAddRoomsWithCapacitiesAndAccommodationsWithSuccess() {

        Address address = new Address(null, "Brazil", "Rio de Janeiro", "Centro", "Rua", "Rua do imperador", "01", "08552-048");    
        addressRepository.save(address);
        Hotel hotel = new Hotel(null, "Alcantara Imperirum", "24 35474-8255", "alcantaraimperirum@mail.com", "99-5841/0001-01", address);
        hotelRepository.save(hotel);
        Capacity capacity = new Capacity(null, "double bed", 2, null);
        capacityRepository.save(capacity);
        RoomItem roomItem = new RoomItem(null, "Tv", "flat tv", null);
        roomItemRepository.save(roomItem);
        Set<RoomItem> roomItems = Set.of(roomItem);
        
        
        Room room = new Room(null, "Room with mountain view", 20.0F, "Livre", hotel, capacity, roomItems);

        roomRepository.save(room);

        List<Room> rooms = roomRepository.findAll();

        assertEquals("Alcantara Imperirum", rooms.getFirst().getHotel().getName());
        assertEquals("Rio de Janeiro", rooms.getFirst().getHotel().getAddress().getState());
        assertEquals("double bed", rooms.getFirst().getCapacity().getName());
        assertEquals("Tv", rooms.getFirst().getRoomItems().stream().findFirst().get().getItem());
        assertEquals("Room with mountain view", rooms.getFirst().getDescription());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + rooms.size());

    }
    
}
