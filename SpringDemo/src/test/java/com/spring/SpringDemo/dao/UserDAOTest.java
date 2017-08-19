package com.spring.SpringDemo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.spring.SpringDemo.exception.UserNotFoundException;
import com.spring.SpringDemo.model.User;

import junit.framework.TestCase;


public class UserDAOTest {
	
	UserDAO dao;
	List<User> users;
	private User user1;
	private User user2;
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	@Before
	public  void start() {
		dao = new UserDAO();
		users = new ArrayList<User>();
		user1 = new User("1", "Mary", "Poppins"); 
		user2 = new User("2", "Bobby", "Poppins");
		users.add(user1);
		users.add(user2);
	}
	
	@Test
	public void getAllUsersTest() {
		
		List<User> testUsers = dao.getUsers();
		assertTrue(testUsers.get(0).getFirstName().equals(user1.getFirstName()));
		assertTrue(testUsers.get(1).getFirstName().equals(user2.getFirstName()));
		
	}
	
	@Test
	public void getUserTest() {
		try {
			String id = "1";
			User user = dao.getUser(id);
			assertEquals(user.getFirstName(), user1.getFirstName());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void memberDoesNotExistTest() {
		try {
			String id = "3";
			User user = dao.getUser(id);
			thrown.expect(UserNotFoundException.class);
		}catch(Exception e) {
			
		}
	}
}
