package org.celebino.persistence.service.impl;

import java.util.List;

import org.celebino.persistence.dao.IGardenDao;
import org.celebino.persistence.model.Garden;
import org.celebino.persistence.service.IGardenService;

public class GardenService implements IGardenService {
	
	private static IGardenDao gardenDao;
	
	@Override
	public Garden findById(Long id) {
		// TODO Auto-generated method stub
		return gardenDao.findById(id);
	}

	@Override
	public void saveGarden(Garden garden) {
		// TODO Auto-generated method stub
		gardenDao.save(garden);
	}

	@Override
	public void deleteGardenById(long id) {
		// TODO Auto-generated method stub
		gardenDao.delete(id);
	}

	@Override
	public List<Garden> findAllGardens() {
		// TODO Auto-generated method stub
		return (List<Garden>) gardenDao.findAll();
	}

	@Override
	public void deleteAllGardens() {
		// TODO Auto-generated method stub
		gardenDao.deleteAll();
	}

	@Override
	public boolean isGardenExist(Garden garden) {
		// TODO Auto-generated method stub
		return gardenDao.exists(garden.getId());
	}

}
