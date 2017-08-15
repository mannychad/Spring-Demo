package com.spring.SpringDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringDemo.data.UserService;

@RestController
public class User {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/users", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<com.spring.SpringDemo.model.User> getUsers(){
		List<com.spring.SpringDemo.model.User> users = userService.getUsers();
		return users;
	}
}
