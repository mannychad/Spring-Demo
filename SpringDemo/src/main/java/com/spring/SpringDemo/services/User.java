package com.spring.SpringDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringDemo.data.UserService;
import com.spring.SpringDemo.exception.UserNotFoundException;
import com.spring.SpringDemo.model.UserServiceException;

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
	
	@GetMapping(value = "/users/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getUserById(@PathVariable String id){
		try {
			com.spring.SpringDemo.model.User user = userService.getUserById(id);
			return new ResponseEntity(user, HttpStatus.OK);
		}catch(UserNotFoundException e) {
			UserServiceException error = new UserServiceException("404", "Member not found");
			return new ResponseEntity(error, HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			UserServiceException error = new UserServiceException("500", "Internal Server Error");
			return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
