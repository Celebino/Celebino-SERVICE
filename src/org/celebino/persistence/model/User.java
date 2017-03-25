package org.celebino.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	
	@Column
	private String name;
	
	@Id @GeneratedValue
	@Column
	private String username;
	
	@Id @GeneratedValue
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String number;
	
	public User(){}
	
	public User(String name, String username, String email, String number, String password) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.number = number;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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


	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", email=" + email + ", number=" + number + "]";
	}
}
