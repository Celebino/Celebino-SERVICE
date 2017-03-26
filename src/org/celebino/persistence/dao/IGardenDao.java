package org.celebino.persistence.dao;

import org.celebino.persistence.model.ArtificialLight;
import org.celebino.persistence.model.Garden;
import org.springframework.data.repository.CrudRepository;

public interface IGardenDao extends CrudRepository<Garden, Long> {
	public Garden findById(Long id);
}
