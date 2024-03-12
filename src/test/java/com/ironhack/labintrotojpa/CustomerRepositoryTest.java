package com.ironhack.labintrotojpa;

import com.ironhack.labintrotojpa.model.Customer;
import com.ironhack.labintrotojpa.model.CustomerStatus;
import com.ironhack.labintrotojpa.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp(){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Jaime Lopez", CustomerStatus.NONE, 20345));
        customers.add(new Customer("Maira Anchex", CustomerStatus.GOLD, 20));
        customers.add(new Customer("Silvina Kratz", CustomerStatus.SILVER, 3456));

        customerRepository.saveAll(customers);
    }

    @AfterEach
    void tearDown(){
        customerRepository.deleteAll();
    }

    @Test
    @DisplayName("Verify a new customer is created")
    public void createNewCostumer(){
        List<Customer> customers = customerRepository.findAll();
        assertEquals(3, customers.size());
    }

    @Test
    @DisplayName("Find customer by name")
    public void findCostumerByName(){
        Optional<Customer> result = customerRepository.findByCustomerName("Maira Anchex");
        assertTrue(result.isPresent());
        assertEquals("Maira Anchex", result.get().getCustomerName());
    }

    @Test
    @DisplayName("Find customer by status")
    public void findCustomerByStatus(){
        Optional<Customer> silverCustomer = customerRepository.findByCustomerStatus(CustomerStatus.SILVER);
        assertEquals(CustomerStatus.SILVER, silverCustomer.get().getCustomerStatus());
    }
}
