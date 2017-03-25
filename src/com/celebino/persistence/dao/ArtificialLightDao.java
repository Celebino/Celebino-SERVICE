package com.celebino.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.celebino.persistence.model.ArtificialLight;

public interface ArtificialLightDao extends CrudRepository<ArtificialLight, Long> {
	public ArtificialLight findById(Long id);

}
