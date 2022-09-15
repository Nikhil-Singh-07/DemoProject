package com.springframework.rest.webservices.DemoProject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import com.springframework.rest.webservices.DemoProject.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();

	private static int usersCount = 3;

	static {
		users.add(new User(1, "Nikhil", new Date()));
		users.add(new User(2, "Mangal", new Date()));
		users.add(new User(3, "Prakhar", new Date()));
	}
    // retrieve all users
	public List<User> findAll() {
		return users;
	} 
	
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user); 
		return user;
	}
	// retrieve one user
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	public User updateById(int id, String newName) {
		for (User user:users) {
			if(user.getId()==id) {
				user.setName(newName);
				return user;
			}
			
		}
		return null;
	}
}

