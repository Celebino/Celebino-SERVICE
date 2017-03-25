package org.celebino.persistence.dao;

import org.celebino.persistence.model.ArtificialLight;
import org.springframework.data.repository.CrudRepository;

public interface ArtificialLightDao extends CrudRepository<ArtificialLight, Long> {
	public ArtificialLight findById(Long id);

}
