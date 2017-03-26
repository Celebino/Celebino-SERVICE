package org.celebino.persistence.dao;

import org.celebino.persistence.model.Watering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWateringDao extends CrudRepository<Watering, Long> {
	public Watering findById(Long id);
}
