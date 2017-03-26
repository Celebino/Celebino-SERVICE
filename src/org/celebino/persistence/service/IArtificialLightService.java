package org.celebino.persistence.service;

import java.util.List;

import org.celebino.persistence.model.ArtificialLight;

public interface IArtificialLightService {
	
	
	ArtificialLight findById(Long id);
	
    void saveArtificialLight(ArtificialLight artificialLight);
     
    void deleteArtificialLightById(long id);
 
    List<ArtificialLight> findAllArtificialLights(); 
     
    void deleteAllArtificialLights();
     
    public boolean isArtificialLightExist(ArtificialLight artificialLight);
	
}
