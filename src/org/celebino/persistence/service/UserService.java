package org.celebino.persistence.service;

import java.util.List;

import org.celebino.persistence.dao.UserDAO;
import org.celebino.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	private UserDAO userDao;
	
	public UserDAO getUserDAO(){
		return userDao;
	}
	
	@Autowired
	public void setUserDao(UserDAO userDao) {
	this.userDao = userDao;
	}
	 
	public void addUser(User user) {
		getUserDAO().insert(user);
	}
	 
	public List<User> fetchAllUsers() {
	return getUserDAO().selectAll();
	}
}

