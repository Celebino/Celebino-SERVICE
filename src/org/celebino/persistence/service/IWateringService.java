package org.celebino.persistence.service;

import java.util.List;

import org.celebino.persistence.model.Watering;


public interface IWateringService {


	Watering findById(Long id);
	
    void saveWatering(Watering watering);
     
    void deleteWateringById(long id);
 
    List<Watering> findAllWaterings(); 
     
    void deleteAllWaterings();
     
    public boolean isWateringExist(Watering watering);
}
