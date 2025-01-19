package com.tekarch.TafFlightService.Model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FlightDTO {
    private Long id;
    private String flight_number;
    private String departure;
    private String arrival;
    private LocalDateTime departure_time;
    private LocalDateTime arrival_time;
    private BigDecimal price;
    private int available_seats;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
