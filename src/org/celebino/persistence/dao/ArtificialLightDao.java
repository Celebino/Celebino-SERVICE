package org.celebino.persistence.dao;

import org.celebino.persistence.model.ArtificialLight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtificialLightDao extends CrudRepository<ArtificialLight, Long> {
	public ArtificialLight findById(Long id);

}
