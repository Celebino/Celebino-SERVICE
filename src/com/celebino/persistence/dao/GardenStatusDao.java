package com.celebino.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.celebino.persistence.model.ArtificialLight;
import com.celebino.persistence.model.GardenStatus;

public interface GardenStatusDao extends CrudRepository<GardenStatus, Long> {
	public GardenStatus findById(Long id);

}
