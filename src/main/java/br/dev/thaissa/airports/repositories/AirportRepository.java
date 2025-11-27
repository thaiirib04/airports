
package br.dev.thaissa.airports.repositories;

import br.dev.thaissa.airports.entities.Airport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long>{
    
    List<Airport> findByCityIgnoreCase(String city);
}
