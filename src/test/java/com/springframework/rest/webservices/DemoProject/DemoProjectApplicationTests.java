package com.springframework.rest.webservices.DemoProject;

import com.springframework.rest.webservices.DemoProject.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.springframework.rest.webservices.DemoProject.repository.CustomerRepository;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoProjectApplicationTests {

	@Autowired
	CustomerRepository customerRepository;


	@Test
	public void createCustomerRepository() {
		Customer customer = new Customer();
		customer.setId(16L);
		customer.setName("Nikhil");
		customer.setAddress("Bihar");
		customerRepository.save(customer);
		assertNotNull(customerRepository.findById(16L).get());

	}

	@Test
	public void getAllRecords(){
		List<Customer> list = customerRepository.findAll();
		assertThat(list).size().isGreaterThan(0);

	}

	@Test
	public void getRecordById(){
		customerRepository.findById(18L);
	}

	@Test
	public void updateById(){
		Customer customer = customerRepository.findById(10L).get();
		customer.setName("Nikhil");
		customerRepository.save(customer);
		assertNotEquals("nikhil", customerRepository.findById(10L).get().getName());
	}

	@Test
	public void deleteById(){
		customerRepository.deleteById(17L);
		assertThat(customerRepository.existsById(17L)).isFalse();
	}

}