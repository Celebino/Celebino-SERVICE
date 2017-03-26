package org.celebino.persistence.service.impl;

import java.util.List;

import org.celebino.persistence.dao.IWateringDao;
import org.celebino.persistence.model.Watering;
import org.celebino.persistence.service.IWateringService;

public class WateringService implements IWateringService {
	
	private static IWateringDao wateringDao;
	
	@Override
	public Watering findById(Long id) {
		// TODO Auto-generated method stub
		return wateringDao.findById(id);
	}

	@Override
	public void saveWatering(Watering watering) {
		// TODO Auto-generated method stub
		wateringDao.save(watering);
	}


	@Override
	public void deleteWateringById(long id) {
		// TODO Auto-generated method stub
		wateringDao.delete(id);
	}

	@Override
	public List<Watering> findAllWaterings() {
		// TODO Auto-generated method stub
		return (List<Watering>) wateringDao.findAll();
	}

	@Override
	public void deleteAllWaterings() {
		// TODO Auto-generated method stub
		wateringDao.deleteAll();
	}

	@Override
	public boolean isWateringExist(Watering watering) {
		// TODO Auto-generated method stub
		return wateringDao.exists(watering.getId());
	}

}
