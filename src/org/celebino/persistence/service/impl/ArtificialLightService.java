package org.celebino.persistence.service.impl;

import java.util.List;


import org.celebino.persistence.dao.IArtificialLightDao;
import org.celebino.persistence.model.ArtificialLight;
import org.celebino.persistence.service.IArtificialLightService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ArtificialLightService")
@Transactional
public class ArtificialLightService implements IArtificialLightService {

    private static IArtificialLightDao artificialLightDao;
	
    
    
	@Override
	public ArtificialLight findById(Long id) {
		// TODO Auto-generated method stub
		return artificialLightDao.findById(id);
	}

	@Override
	public void saveArtificialLight(ArtificialLight artificialLight) {
		// TODO Auto-generated method stub
		artificialLightDao.save(artificialLight);
	}


	@Override
	public void deleteArtificialLightById(long id) {
		// TODO Auto-generated method stub
		artificialLightDao.delete(id);
	}

	@Override
	public List<ArtificialLight> findAllArtificialLights() {
		// TODO Auto-generated method stub
		 return (List<ArtificialLight>) artificialLightDao.findAll();
	}

	@Override
	public void deleteAllArtificialLights() {
		// TODO Auto-generated method stub
		artificialLightDao.deleteAll();
	}

	@Override
	public boolean isArtificialLightExist(ArtificialLight artificialLight) {
		// TODO Auto-generated method stub
		return artificialLightDao.exists(artificialLight.getId());
	}

}
