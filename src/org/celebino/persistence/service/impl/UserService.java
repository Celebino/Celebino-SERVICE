package org.celebino.persistence.service.impl;

import java.util.List;

import org.celebino.persistence.dao.IUserDao;
import org.celebino.persistence.model.User;
import org.celebino.persistence.service.IUserService;
import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService {

    private static IUserDao userDao;

	
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

	@Override
	public User findByUserEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userDao.findAll();	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		userDao.deleteAll();
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return userDao.exists(user.getId());
	}
	
}

