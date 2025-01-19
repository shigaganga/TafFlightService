package com.tekarch.TafFlightService.Service.Interface;

import com.tekarch.TafFlightService.Model.FlightDTO;

import java.util.List;

public interface FlightService {
    FlightDTO addFlight(FlightDTO flightDTO);
    List<FlightDTO> getAllFlights();
    FlightDTO getFlightById(Long id);
    FlightDTO updateFlightById(Long id,FlightDTO flightDTO);
    boolean deleteFlight(Long id);
}
