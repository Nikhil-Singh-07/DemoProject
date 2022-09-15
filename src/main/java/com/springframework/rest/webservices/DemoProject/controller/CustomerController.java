package com.springframework.rest.webservices.DemoProject.controller;

import com.springframework.rest.webservices.DemoProject.exception.UserNotFoundException;
import com.springframework.rest.webservices.DemoProject.model.Customer;
import com.springframework.rest.webservices.DemoProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    public CustomerController() {
//        customerService = null;
//    }
//    @Autowired
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }


    @GetMapping("/customers")
    public List<Customer> retrieveAllUsers() {
        return customerService.findAll();


    }


    @GetMapping("/customer/{id}")
    public ResponseEntity<?> retrieveCustomer(@PathVariable Long id) {
        Customer user = customerService.getCustomer(id);
        if (user == null) {
            return  ResponseEntity.status(HttpStatus.OK)
                    .body("Not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


    @PostMapping("/create-customer")

    public String createCustomer(@RequestBody Customer customer) {
        Customer savedUser = customerService.createCustomer(customer);
        if(savedUser==null)
        {
            return "Error in Creating customer";
        }
        return "Successfully Created..";
    }


    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        String message=customerService.deleteCustomer(id);
        if (message == null) {
            throw new UserNotFoundException("id-" + id);
        }

        return message;
    }
    @PutMapping("customer/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer user = customerService.updateCustomer(id, customer);
        if (user == null) {
            return  ResponseEntity.status(HttpStatus.OK)
                    .body("Not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
