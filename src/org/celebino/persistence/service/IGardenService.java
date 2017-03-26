package org.celebino.persistence.service;

import java.util.List;

import org.celebino.persistence.model.Garden;


public interface IGardenService {


	Garden findById(Long id);
	
    void saveGarden(Garden garden);
          
    void deleteGardenById(long id);
 
    List<Garden> findAllGardens(); 
     
    void deleteAllGardens();
     
    public boolean isGardenExist(Garden garden);
}
