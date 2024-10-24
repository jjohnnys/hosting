package br.com.jjohnnys.hosting_api.hotel.reporitory;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jjohnnys.hosting_api.hotel.domains.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, UUID> {
    
}
