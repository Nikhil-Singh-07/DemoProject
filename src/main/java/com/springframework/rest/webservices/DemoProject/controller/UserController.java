package com.springframework.rest.webservices.DemoProject.controller;

import com.springframework.rest.webservices.DemoProject.service.UserDaoService;
import com.springframework.rest.webservices.DemoProject.exception.UserNotFoundException;
import com.springframework.rest.webservices.DemoProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
public class UserController {


	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}


	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user =  service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		return user;
	}


	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		User savedUser = service.save(user);
	}


	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if (user == null) {
		  throw new  UserNotFoundException("id-" + id);
		}
	}
	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable int id, @RequestBody String name) {
		 User user = service.updateById(id, name);
		 if (user == null) {
			throw new  UserNotFoundException("id-"+id);
		 }

	}

}

