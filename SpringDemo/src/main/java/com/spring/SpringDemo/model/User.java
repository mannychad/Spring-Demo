package com.spring.SpringDemo.model;

public class User {
	
	private String firstName;
	private String lastName;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User() {
		
	}
	public User (String firstName, String lastName) {
		this.firstName =  firstName;
		this.lastName = lastName;
	}
	
	public User (String id, String firstName, String lastName) {
		this.id = id;
		this.firstName =  firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
