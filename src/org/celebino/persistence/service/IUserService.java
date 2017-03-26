package org.celebino.persistence.service;

import java.util.List;

import org.celebino.persistence.model.User;


public interface IUserService {


	User findById(Long id);
	
	User findByUsername(String username);
	
	User findByUserEmail(String email);
	
    void saveUser(User user);
     
    void deleteUserById(long id);
 
    List<User> findAllUsers(); 
     
    void deleteAllUsers();
     
    public boolean isUserExist(User user);
}
