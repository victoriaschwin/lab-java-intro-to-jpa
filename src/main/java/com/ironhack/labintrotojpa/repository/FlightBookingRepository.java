package com.ironhack.labintrotojpa.repository;

import com.ironhack.labintrotojpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking,Integer> {

}
