package com.celebino.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.celebino.persistence.model.ArtificialLight;
import com.celebino.persistence.model.User;

public interface UserDao extends CrudRepository<User, String>{
	public User findByUsername(String username);

}
