package org.celebino.persistence.service;

import java.util.List;

import org.celebino.persistence.model.GardenStatus;

public interface IGardenStatusService {


	GardenStatus findById(Long id);
	
    void saveGardenStatus(GardenStatus gardenStatus);
          
    void deleteGardenStatusById(long id);
 
    List<GardenStatus> findAllGardenStatus(); 
     
    void deleteAllGardenStatus();
     
    public boolean isGardenStatusExist(GardenStatus gardenStatus);
}
