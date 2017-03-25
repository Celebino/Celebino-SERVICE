package com.celebino.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.celebino.persistence.model.ArtificialLight;
import com.celebino.persistence.model.Garden;

public interface GardenDao extends CrudRepository<Garden, Long> {
	public Garden findById(Long id);

}
