package com.tekarch.TafFlightService.Service;

import com.tekarch.TafFlightService.Model.FlightDTO;
import com.tekarch.TafFlightService.Service.Interface.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private RestTemplate restTemplate;
   // private final String DATASOURCE_URL = "http://localhost:8080/flights"; // URL to TafDatastoreService
   @Value("${datasource.url}")
   private String DATASOURCE_URL;

    @Override
    public FlightDTO addFlight(FlightDTO flightDTO) {
        ResponseEntity<FlightDTO> response=restTemplate.postForEntity(DATASOURCE_URL,flightDTO, FlightDTO.class);
        System.out.println("response"+response.getBody());
        return response.getBody();
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        List<FlightDTO> flights=restTemplate.exchange(DATASOURCE_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<FlightDTO>>() {
        }).getBody();
return flights;
    }

    @Override
    public FlightDTO getFlightById(Long id) {
        String url= DATASOURCE_URL+"/"+id;
      return  restTemplate.getForObject(url, FlightDTO.class);
    }

    @Override
    public FlightDTO updateFlightById(Long id, FlightDTO flightDTO) {
        String url= DATASOURCE_URL+"/"+id;
        restTemplate.put(url,flightDTO);
        return flightDTO;
    }

    @Override
    public boolean deleteFlight(Long id) {
        String url = DATASOURCE_URL+"/"+id;
        try {
            restTemplate.delete(url); // Attempt to delete the flight
            return true; // Return true if no exception occurs
        } catch (HttpClientErrorException.NotFound e) {
            // Handle case where the resource does not exist (404 Not Found)
            return false;
        } catch (RestClientException e) {
            // Handle other exceptions, such as connection issues
            throw new RuntimeException("Failed to delete flight: " + e.getMessage(), e);
        }
    }
}
