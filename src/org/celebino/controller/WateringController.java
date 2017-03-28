package org.celebino.controller;

import java.util.List;

import org.celebino.persistence.model.Watering;
import org.celebino.persistence.service.impl.WateringService;
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
public class WateringController {
	
	@Autowired
	WateringService wateringService;
	
	 
    //-------------------Retrieve All Waterings--------------------------------------------------------
     
    @RequestMapping(value = "/watering/", method = RequestMethod.GET)
    public ResponseEntity<List<Watering>> listAllWaterings() {
        List<Watering> waterings = wateringService.findAllWaterings();
        if(waterings.isEmpty()){
            return new ResponseEntity<List<Watering>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Watering>>(waterings, HttpStatus.OK);
    }
 
 
    //-------------------Retrieve Single Watering--------------------------------------------------------
     
    @RequestMapping(value = "/watering/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Watering> getWatering(@PathVariable("id") long id) {
        System.out.println("Fetching Watering with id " + id);
        Watering watering = wateringService.findById(id);
        if (watering == null) {
            System.out.println("Watering with id " + id + " not found");
            return new ResponseEntity<Watering>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Watering>(watering, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Watering--------------------------------------------------------
     
    @RequestMapping(value = "/watering/", method = RequestMethod.POST)
    public ResponseEntity<Void> createWatering(@RequestBody Watering watering,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Watering " + watering.getId());
 
        if (wateringService.isWateringExist(watering)) {
            System.out.println("A Watering with id " + watering.getId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        wateringService.saveWatering(watering);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/watering/{id}").buildAndExpand(watering.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
     
    //------------------- Update a Watering --------------------------------------------------------
     
    @RequestMapping(value = "/watering/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Watering> updateWatering(@PathVariable("id") long id, @RequestBody Watering watering) {
        System.out.println("Updating Watering " + id);
         
        Watering currentWatering = wateringService.findById(id);
         
        if (currentWatering == null) {
            System.out.println("Watering with id " + id + " not found");
            return new ResponseEntity<Watering>(HttpStatus.NOT_FOUND);
        }
 
        currentWatering.setDate(watering.getDate());
        currentWatering.setGarden(watering.getGarden());       
    
         
        wateringService.saveWatering(currentWatering);
        return new ResponseEntity<Watering>(currentWatering, HttpStatus.OK);
    }
 
    //------------------- Delete a Watering --------------------------------------------------------
     
    @RequestMapping(value = "/watering/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Watering> deleteWatering(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Watering with id " + id);
 
        Watering watering = wateringService.findById(id);
        if (watering == null) {
            System.out.println("Unable to delete. Watering with id " + id + " not found");
            return new ResponseEntity<Watering>(HttpStatus.NOT_FOUND);
        }
 
        wateringService.deleteWateringById(id);
        return new ResponseEntity<Watering>(HttpStatus.NO_CONTENT);
    }
 
     
    //------------------- Delete All Waterings --------------------------------------------------------
     
    @RequestMapping(value = "/watering/", method = RequestMethod.DELETE)
    public ResponseEntity<Watering> deleteWaterings() {
        System.out.println("Deleting All Waterings");
 
        wateringService.deleteAllWaterings();
        return new ResponseEntity<Watering>(HttpStatus.NO_CONTENT);
    }
	
}
