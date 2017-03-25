package org.celebino.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	
	@Id @GeneratedValue
	@Column
	private Long Id;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String username;
	
	@Column
	private String name;
	
	@Column
	private String password;
	
	@Column
	private String number;
	
	public User(){}
	
	public User(Long id, String email, String username, String name, String password, String number) {
		super();
		Id = id;
		this.email = email;
		this.username = username;
		this.name = name;
		this.password = password;
		this.number = number;
	}


	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
