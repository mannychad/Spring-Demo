package com.spring.SpringDemo.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringDemo.dao.UserDAO;
import com.spring.SpringDemo.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDAO userDAO;
	
	public List<User> getUsers(){
		List<User> users = userDAO.getUsers();
		if(users != null && users.size() == 0) {
			return new ArrayList<User>();
		}
		return users;
	}
	
	public User getUserById(String id) throws Exception {
		try {
			User user = userDAO.getUser(id);
			return user;
		}catch(Exception e) {
			throw e;
		}
	}
}
