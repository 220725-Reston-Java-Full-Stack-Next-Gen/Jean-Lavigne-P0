package com.jean.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate hireDate;
	private UserRole userRole;
	private List<Reimbursement> reimb = new ArrayList<Reimbursement>();
	//no args constructor >source> generate constructor and superclass
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	// all-args constructor >source>generate constructor using fields
	public User(int userId, String username, String password, String firstName, String lastName, String email,
			LocalDate hireDate, UserRole userRole, List<Reimbursement> reimb) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
		this.userRole = userRole;
		this.reimb = reimb;
	}
	// all-args constructor >source>generate constructor using fields without ID
	public User(String username, String password, String firstName, String lastName, String email, LocalDate hireDate,
			UserRole userRole, List<Reimbursement> reimb) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
		this.userRole = userRole;
		this.reimb = reimb;
	}
	//getters and setters >source> generate getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<Reimbursement> getReimb() {
		return reimb;
	}

	public void setReimb(List<Reimbursement> reimb) {
		this.reimb = reimb;
	}
	//to-string method >source> generate toString method
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", hireDate=" + hireDate + ", userRole="
				+ userRole + ", reimb=" + reimb + "]";
	}

}
