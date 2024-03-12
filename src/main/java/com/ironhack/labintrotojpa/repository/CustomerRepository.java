package com.ironhack.labintrotojpa.repository;

import com.ironhack.labintrotojpa.model.Customer;
import com.ironhack.labintrotojpa.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByCustomerName(String customerName);
    Optional<Customer> findByCustomerStatus(CustomerStatus customerStatus);
}
