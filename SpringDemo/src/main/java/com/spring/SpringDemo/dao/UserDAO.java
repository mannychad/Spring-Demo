package com.spring.SpringDemo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.SpringDemo.exception.UserNotFoundException;
import com.spring.SpringDemo.model.User;

@Repository
public class UserDAO {
	
	
	private static User user1 = new User("1", "Mary", "Poppins"); 
	private static User user2 = new User("2", "Bobby", "Poppins"); 
	public static List<User> users = new ArrayList<User>();
	static {
		users.add(user1);
		users.add(user2);
	}
	public List<User> getUsers() {
		if(users != null && users.size() > 0) {
			return users;
		}else {
			return Collections.emptyList();
		}
	}
	public User getUser(String id) throws Exception {
		try {
			for(User member: users) {
				if(member.getId().equalsIgnoreCase(id)) {
					return member;
				}
			}
			throw new UserNotFoundException();
		}catch(Exception e) {
			throw e;
		}
	}

}
