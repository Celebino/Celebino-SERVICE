package org.celebino.controller;

import java.util.List;

import org.celebino.persistence.model.Garden;
import org.celebino.persistence.service.impl.GardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class GardenController {
	
	@Autowired
	GardenService gardenService;
	
	 
    //-------------------Retrieve All Gardens--------------------------------------------------------
     
    @RequestMapping(value = "/garden/", method = RequestMethod.GET)
    public ResponseEntity<List<Garden>> listAllArtificialLights() {
        List<Garden> gardens = gardenService.findAllGardens();
        if(gardens.isEmpty()){
            return new ResponseEntity<List<Garden>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Garden>>(gardens, HttpStatus.OK);
    }
 
 
    //-------------------Retrieve Single Garden--------------------------------------------------------
     
    @RequestMapping(value = "/garden/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Garden> getGarden(@PathVariable("id") long id) {
        System.out.println("Fetching Garden with id " + id);
        Garden garden = gardenService.findById(id);
        if (garden == null) {
            System.out.println("Garden with id " + id + " not found");
            return new ResponseEntity<Garden>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Garden>(garden, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Garden--------------------------------------------------------
     
    @RequestMapping(value = "/garden/", method = RequestMethod.POST)
    public ResponseEntity<Void> createGarden(@RequestBody Garden garden,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Garden " + garden.getId());
 
        if (gardenService.isGardenExist(garden)) {
            System.out.println("A Garden with id " + garden.getId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        gardenService.saveGarden(garden);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/garden/{id}").buildAndExpand(garden.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
     
    //------------------- Update a Garden --------------------------------------------------------
     
    @RequestMapping(value = "/garden/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Garden> updateGarden(@PathVariable("id") long id, @RequestBody Garden garden) {
        System.out.println("Updating Garden " + id);
         
        Garden currentGarden = gardenService.findById(id);
         
        if (currentGarden == null) {
            System.out.println("Garden with id " + id + " not found");
            return new ResponseEntity<Garden>(HttpStatus.NOT_FOUND);
        }
 
        currentGarden.setUser(garden.getUser());
        currentGarden.setSoilHumidity(garden.getSoilHumidity());
        currentGarden.setAirTemperature(garden.getAirTemperature());
        currentGarden.setAirHumidity(garden.getAirHumidity());
        currentGarden.setSunLight(garden.getSunLight());
        
        gardenService.saveGarden(currentGarden);
        return new ResponseEntity<Garden>(currentGarden, HttpStatus.OK);
    }
 
    //------------------- Delete a Garden --------------------------------------------------------
     
    @RequestMapping(value = "/garden/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Garden> deleteGarden(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Garden with id " + id);
 
        Garden garden = gardenService.findById(id);
        if (garden == null) {
            System.out.println("Unable to delete. Garden with id " + id + " not found");
            return new ResponseEntity<Garden>(HttpStatus.NOT_FOUND);
        }
 
        gardenService.deleteGardenById(id);
        return new ResponseEntity<Garden>(HttpStatus.NO_CONTENT);
    }
 
     
    //------------------- Delete All Gardens --------------------------------------------------------
     
    @RequestMapping(value = "/garden/", method = RequestMethod.DELETE)
    public ResponseEntity<Garden> deleteAllGardens() {
        System.out.println("Deleting All Gardens");
 
        gardenService.deleteAllGardens();
        return new ResponseEntity<Garden>(HttpStatus.NO_CONTENT);
    }
	
}
