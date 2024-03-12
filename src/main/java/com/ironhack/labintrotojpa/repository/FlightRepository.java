package com.ironhack.labintrotojpa.repository;

import com.ironhack.labintrotojpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository {
    Optional<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContaining(String aircraft);
    List<Flight> findByFlightMileageGreaterThan(Integer mileage);
}
