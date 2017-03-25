package org.celebino.persistence.dao;

import org.celebino.persistence.model.ArtificialLight;
import org.celebino.persistence.model.Watering;
import org.springframework.data.repository.CrudRepository;

public interface WateringDao extends CrudRepository<Watering, Long> {
	public Watering findById(Long id);
}
