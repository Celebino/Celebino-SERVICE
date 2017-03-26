package org.celebino.persistence.service.impl;

import java.util.List;

import org.celebino.persistence.dao.GardenStatusDao;
import org.celebino.persistence.model.GardenStatus;
import org.celebino.persistence.service.IGardenStatusService;

public class GardenStatusService implements IGardenStatusService {
	
	private static GardenStatusDao gardenStatusDao;
	
	@Override
	public GardenStatus findById(Long id) {
		// TODO Auto-generated method stub
		return gardenStatusDao.findById(id);
	}

	@Override
	public void saveGardenStatus(GardenStatus gardenStatus) {
		// TODO Auto-generated method stub
		gardenStatusDao.save(gardenStatus);
	}

	@Override
	public void deleteGardenStatusById(long id) {
		// TODO Auto-generated method stub
		gardenStatusDao.delete(id);
	}

	@Override
	public List<GardenStatus> findAllGardenStatus() {
		// TODO Auto-generated method stub
		return (List<GardenStatus>) gardenStatusDao.findAll();
	}

	@Override
	public void deleteAllGardenStatus() {
		// TODO Auto-generated method stub
		gardenStatusDao.deleteAll();
	}

	@Override
	public boolean isGardenStatusExist(GardenStatus gardenStatus) {
		// TODO Auto-generated method stub
		return gardenStatusDao.exists(gardenStatus.getId());
	}

}
