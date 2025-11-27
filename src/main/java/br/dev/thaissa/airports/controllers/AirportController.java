
package br.dev.thaissa.airports.controllers;

import br.dev.thaissa.airports.entities.Airport;
import br.dev.thaissa.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController {
    
    @Autowired
    private AirportService airportService;
    
    /**
     * Endpoint /airports/airport
     * Retorna TODOS os aeroportos da base de dados.
     * @return
     */
    @GetMapping("/airport")
    public List<Airport> findAll(){
        List<Airport> result = airportService.findAll();
        return result;
    }
    
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName){
        List<Airport> result = airportService.findByCity(cityName);
        
        if(result.isEmpty()){
            //ops... lista vazia...
            // notFound devolve 404
            return ResponseEntity.notFound().build();
        } else {
            //eba! tem dados!
            //ok devolve 200
            return ResponseEntity.ok(result);
        }
    }
}
