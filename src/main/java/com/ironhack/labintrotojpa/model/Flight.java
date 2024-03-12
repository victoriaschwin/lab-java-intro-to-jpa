package com.ironhack.labintrotojpa.model;

import jakarta.persistence.*;

@Entity
@Table(name="flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer flightId;
    private String flightNumber;
    private String aircraft;
    @Column(name = "total_aircraft_seat")
    private Integer totalAircraftSeat;
    private Integer flightMileage;

    public Flight(){}

    public Flight(String flightNumber, String aircraft, Integer totalAircraftSeat, Integer flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeat = totalAircraftSeat;
        this.flightMileage = flightMileage;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public Integer getTotalAircraftSeat() {
        return totalAircraftSeat;
    }

    public void setTotalAircraftSeat(Integer totalAircraftSeat) {
        this.totalAircraftSeat = totalAircraftSeat;
    }

    public Integer getFlightMileage() {
        return flightMileage;
    }

    public void setFlightMileage(Integer flightMileage) {
        this.flightMileage = flightMileage;
    }
}
