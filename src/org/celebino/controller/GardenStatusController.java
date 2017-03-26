package org.celebino.controller;

import java.util.List;

import org.celebino.persistence.model.GardenStatus;
import org.celebino.persistence.service.impl.GardenStatusService;
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
public class GardenStatusController {
	
	@Autowired
	GardenStatusService gardenStatusService;
	
	 
    //-------------------Retrieve All Gardens Status--------------------------------------------------------
     
    @RequestMapping(value = "/gardenStatus/", method = RequestMethod.GET)
    public ResponseEntity<List<GardenStatus>> listAllGardenStatus() {
        List<GardenStatus> gardenstatus = gardenStatusService.findAllGardenStatus();
        if(gardenstatus.isEmpty()){
            return new ResponseEntity<List<GardenStatus>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<GardenStatus>>(gardenstatus, HttpStatus.OK);
    }
 
 
    //-------------------Retrieve Single Garden Status--------------------------------------------------------
     
    @RequestMapping(value = "/gardenStatus/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GardenStatus> getGardenStatus(@PathVariable("id") long id) {
        System.out.println("Fetching Garden Status with id " + id);
        GardenStatus gardenStatus = gardenStatusService.findById(id);
        if (gardenStatus == null) {
            System.out.println("Garden Status with id " + id + " not found");
            return new ResponseEntity<GardenStatus>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<GardenStatus>(gardenStatus, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Garden Status--------------------------------------------------------
     
    @RequestMapping(value = "/gardenStatus/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody GardenStatus gardenStatus,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Garden Status " + gardenStatus.getId());
 
        if (gardenStatusService.isGardenStatusExist(gardenStatus)) {
            System.out.println("A Garden Status with id " + gardenStatus.getId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        gardenStatusService.saveGardenStatus(gardenStatus);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/gardenStatus/{id}").buildAndExpand(gardenStatus.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
     
    //------------------- Update a Garden Status --------------------------------------------------------
     
    @RequestMapping(value = "/gardenStatus/{id}", method = RequestMethod.PUT)
    public ResponseEntity<GardenStatus> updateUser(@PathVariable("id") long id, @RequestBody GardenStatus gardenStatus) {
        System.out.println("Updating Garden Status " + id);
         
        GardenStatus currentGardenStatus = gardenStatusService.findById(id);
         
        if (currentGardenStatus == null) {
            System.out.println("Garden Status with id " + id + " not found");
            return new ResponseEntity<GardenStatus>(HttpStatus.NOT_FOUND);
        }
 
        currentGardenStatus.setGardenId(gardenStatus.getGardenId());
        currentGardenStatus.setSoilHumidity(gardenStatus.getSoilHumidity());
        currentGardenStatus.setAirTemperature(gardenStatus.getAirTemperature());
        currentGardenStatus.setAirHumidity(gardenStatus.getAirHumidity());
        currentGardenStatus.setSunLight(gardenStatus.getSunLight());
        currentGardenStatus.setDate(gardenStatus.getDate());        
    
         
        gardenStatusService.saveGardenStatus(currentGardenStatus);
        return new ResponseEntity<GardenStatus>(currentGardenStatus, HttpStatus.OK);
    }
 
    //------------------- Delete a Garden Status --------------------------------------------------------
     
    @RequestMapping(value = "/gardenStatus/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<GardenStatus> deleteGardenStatus(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Garden Status with id " + id);
 
        GardenStatus gardenStatus = gardenStatusService.findById(id);
        if (gardenStatus == null) {
            System.out.println("Unable to delete. Garden Status with id " + id + " not found");
            return new ResponseEntity<GardenStatus>(HttpStatus.NOT_FOUND);
        }
 
        gardenStatusService.deleteGardenStatusById(id);
        return new ResponseEntity<GardenStatus>(HttpStatus.NO_CONTENT);
    }
 
     
    //------------------- Delete All Garden Status --------------------------------------------------------
     
    @RequestMapping(value = "/gardenStatus/", method = RequestMethod.DELETE)
    public ResponseEntity<GardenStatus> deleteGardenStatus() {
        System.out.println("Deleting All Gardens Status");
 
        gardenStatusService.deleteAllGardenStatus();
        return new ResponseEntity<GardenStatus>(HttpStatus.NO_CONTENT);
    }
	
}
