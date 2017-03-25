package org.celebino.persistence.dao;

import org.celebino.persistence.model.ArtificialLight;
import org.celebino.persistence.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long>{
	public User findByUsername(String username);

}
