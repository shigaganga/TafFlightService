package com.tekarch.TafFlightService.Service;

import com.tekarch.TafFlightService.Model.FlightDTO;
import com.tekarch.TafFlightService.Service.Interface.FlightService;

import java.util.List;

public class FlightServiceImpl implements FlightService {
    @Override
    public FlightDTO addFlight(FlightDTO flightDTO) {
        return null;
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        return List.of();
    }

    @Override
    public FlightDTO getFlightById(Long id) {
        return null;
    }

    @Override
    public FlightDTO updateFlightById(Long id, FlightDTO flightDTO) {
        return null;
    }

    @Override
    public boolean deleteFlight(Long id) {
        return false;
    }
}
