package com.springframework.rest.webservices.DemoProject.service;


import com.springframework.rest.webservices.DemoProject.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springframework.rest.webservices.DemoProject.repository.CustomerRepository;

import java.util.List;


@Service
public class CustomerService {
    
    @Autowired
    CustomerRepository customerRepository;


    public List<Customer> findAll() {


        List<Customer> list=null;
        try {
            list=customerRepository.findAll();
        }

        catch (Exception e)
        {
            return null;
        }
        return list;
    }

    public Customer getCustomer(Long id) {

       Customer customer=null;
       try{
           customer=customerRepository.findById(id).get();
       }
       catch (Exception e)
       {
           return null;
       }
       return customer;
    }

    public Customer createCustomer(Customer customer) {


        Customer customer1=null;
        try{
            customer1=customerRepository.save(customer);
        }
        catch (Exception e)
        {
            return null;
        }

        return customer1;
    }

    public String deleteCustomer(Long id) {

        try{
            customerRepository.deleteById(id);
        }
        catch (Exception e)
        {
            return null;
        }
        return "Deleted Successfully..";
    }

    public Customer updateCustomer(Long id, Customer customer) {

        Customer newCustomer=null;
        try{
             newCustomer=customerRepository.findById(id).get();
        }
        catch (Exception e) {
            return null;
        }
        newCustomer.setAddress(customer.getAddress());
        newCustomer.setName(customer.getName());

        Customer customer1=null;
        try{
            customer1=customerRepository.save(newCustomer);
        }
        catch (Exception e)
        {
            return null;
        }

        return customer1;


    }
}
