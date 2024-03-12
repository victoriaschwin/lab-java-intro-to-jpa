package com.ironhack.labintrotojpa;

import com.ironhack.labintrotojpa.model.Customer;
import com.ironhack.labintrotojpa.model.Flight;
import com.ironhack.labintrotojpa.repository.FlightRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FlightRepositoryTest {

    @Autowired
    FlightRepository flightRepository;

    @BeforeEach
    void setUp(){
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("A234","Airbus 300",400,2800));
        flights.add(new Flight("E1276","Boeing 767", 1200, 54700));
        flights.add(new Flight("F398","Airbus 300", 700, 10000));

        flightRepository.saveAll(flights);
    }

    @AfterEach
    void tearDown(){
        flightRepository.deleteAll();
    }

    @Test
    public void createNewFlight(){
        List<Flight> customers = flightRepository.findAll();
        assertEquals(3, customers.size());
    }

    @Test
    public void findFlightByNumber(){
        Optional<Flight> result = flightRepository.findByFlightNumber("A234");
        assertTrue(result.isPresent());
        assertEquals("A234", result.get().getFlightNumber());
    }

    @Test
    public void findFlightByAircraft(){
        List<Flight> airbus = flightRepository.findByAircraftContaining("Airbus");
        assertEquals(2, airbus.size());
    }

    @Test
    public void findFlightByMileageGreaterThan(){
        List<Flight> mileageFlights = flightRepository.findByFlightMileageGreaterThan(20000);
        assertEquals(1,mileageFlights.size());
    }
}
