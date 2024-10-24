package br.com.jjohnnys.hosting_api.hotel.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jjohnnys.hosting_api.hotel.domains.Capacity;

@Repository
public interface CapacityRepository extends JpaRepository<Capacity, Integer> {
    
}
