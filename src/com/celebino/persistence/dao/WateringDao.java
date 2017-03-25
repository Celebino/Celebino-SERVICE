package com.celebino.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.celebino.persistence.model.ArtificialLight;
import com.celebino.persistence.model.Watering;

public interface WateringDao extends CrudRepository<Watering, Long> {
	public Watering findById(Long id);
}
