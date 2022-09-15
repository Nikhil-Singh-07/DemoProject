package com.springframework.rest.webservices.DemoProject.repository;

import com.springframework.rest.webservices.DemoProject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findById(Long id);
}
