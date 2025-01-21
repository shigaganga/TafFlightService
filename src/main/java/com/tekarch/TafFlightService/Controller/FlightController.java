package com.tekarch.TafFlightService.Controller;

import com.tekarch.TafFlightService.Model.FlightDTO;
import com.tekarch.TafFlightService.Service.FlightServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("flights")
public class FlightController {
    private static final Logger logger = LogManager.getLogger(FlightController.class);
    @Autowired
    private FlightServiceImpl flightServiceImpl;
    @PostMapping
    public FlightDTO createFlight(@RequestBody FlightDTO flightDTO){
        return flightServiceImpl.addFlight(flightDTO);
    }
    @GetMapping
    public List< FlightDTO> getAllFlights(){

        return flightServiceImpl.getAllFlights();
    }
    @ GetMapping("/{id}")
    public FlightDTO getFlightById(@PathVariable Long id){

        return flightServiceImpl.getFlightById(id);
    }
    @PutMapping("/{id}")
    public FlightDTO updateFlight(@PathVariable Long id,@RequestBody FlightDTO flightDTO){
        return flightServiceImpl.updateFlightById(id,flightDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteflight(@PathVariable Long id){
        flightServiceImpl.deleteFlight(id);

    }
    // Exception Handling
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptions(Exception e) {
        logger.error("Exception occurred: {}", e.getMessage());
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
