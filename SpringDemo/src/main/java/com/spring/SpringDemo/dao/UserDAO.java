package com.spring.SpringDemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.SpringDemo.model.User;

@Repository
public class UserDAO {
	
	
	private static User user1 = new User("Mary", "Poppins"); 
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		users.add(user1);
		return users;
	}

}
