
// Author: Jakob Evans

// Assignment: Java Project 1
// Date: 7/19/21

package com.cognixia.jump.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class Customer implements Serializable{

	

	final static private String passwordRegex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[#?!@$%^&*-]).{8,}$";

	final static private String phoneNumberRegex = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";

	
	
	@Id // Pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PHONENUMBER")
	private String phoneNumber;

	@Column(name = "USERNAME", unique = true)
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "INITITALDEPOSIT")
	private Double initialDeposit;

	@Column(name = "CURRENTBALANCE")
	private Double currentBalance;
	


	public Customer(String name, String address, String phoneNumber, String username, String password,
			Double initialDeposit, Double currentBalance) {
		super();

//		this.customerId = maxCustomerId++;
		this.name = name;
		this.address = address;

		this.phoneNumber = phoneNumber;

		this.username = username;

		this.password = password;
		this.initialDeposit = initialDeposit;

		this.currentBalance = currentBalance;
		

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

	public Double getInitialDeposit() {
		return initialDeposit;
	}

	public void setInitialDeposit(Double initialDeposit) {
		this.initialDeposit = initialDeposit;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	


	   @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Customer)) return false;
	        
	        Customer customer = (Customer) o;
	        
	        return Objects.equals(username, customer.username) &&
	                Objects.equals(password, customer.password);
	    }
	   
	   
	    @Override
	    public int hashCode() {
	        return Objects.hash(id, username, password 
	                            );
	    }
	
	public String toJson() {
		
		return "{\"id\" : " + id
				+ ", \"username\" : \"" + username + "\""
				+ ", \"password\" : \"" + password + "\"" +
		"}";
	}

	public Customer() {
		super();
//		this.customerId = maxCustomerId++;
		this.name = "Null";

		this.address = "N/A";

		this.phoneNumber = "0000000000";
		
		this.username = "N/A";

		this.password = "N/A";
		this.initialDeposit = 0.0;

		this.currentBalance = 0.0;
		
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + id + ", name=" + name + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", username=" + username + ", password=" + password + ", initialDeposit="
				+ initialDeposit + ", currentBalance=" + currentBalance + "]";
	}

}
