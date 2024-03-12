package com.ironhack.labintrotojpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customersflights")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingID")
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private Integer customerId;

    @ManyToOne
    @JoinColumn(name = "FlightID", nullable = false)
    private Integer flightId;

    public FlightBooking(){}
    public FlightBooking( Integer customerId, Integer flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }
}
