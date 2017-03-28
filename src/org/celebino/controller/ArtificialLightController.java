package org.celebino.controller;

import java.util.List;

import org.celebino.persistence.model.ArtificialLight;
import org.celebino.persistence.service.impl.ArtificialLightService;
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
public class ArtificialLightController {
	
	@Autowired
	ArtificialLightService artificialLightService;
	
	 
    //-------------------Retrieve All ArtificialLights--------------------------------------------------------
     
    @RequestMapping(value = "/artificialLight/", method = RequestMethod.GET)
    public ResponseEntity<List<ArtificialLight>> listAllArtificialLights() {
        List<ArtificialLight> artificialLights = artificialLightService.findAllArtificialLights();
        if(artificialLights.isEmpty()){
            return new ResponseEntity<List<ArtificialLight>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<ArtificialLight>>(artificialLights, HttpStatus.OK);
    }
 
 
    //-------------------Retrieve Single ArtificialLight--------------------------------------------------------
     
    @RequestMapping(value = "/artificialLight/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArtificialLight> getArtificialLight(@PathVariable("id") long id) {
        System.out.println("Fetching Artificial Light with id " + id);
        ArtificialLight artificialLight = artificialLightService.findById(id);
        if (artificialLight == null) {
            System.out.println("Artificial Light with id " + id + " not found");
            return new ResponseEntity<ArtificialLight>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ArtificialLight>(artificialLight, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a ArtificialLight--------------------------------------------------------
     
    @RequestMapping(value = "/artificialLight/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody ArtificialLight artificialLight,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating ArtificialLIght " + artificialLight.getId());
 
        if (artificialLightService.isArtificialLightExist(artificialLight)) {
            System.out.println("An Artificial Light with id " + artificialLight.getId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        artificialLightService.saveArtificialLight(artificialLight);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/artificialLight/{id}").buildAndExpand(artificialLight.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
     
    //------------------- Update a ArtificialLight --------------------------------------------------------
     
    @RequestMapping(value = "/artificialLight/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ArtificialLight> updateArtificialLight(@PathVariable("id") long id, @RequestBody ArtificialLight artificialLight) {
        System.out.println("Updating Artificial Light " + id);
         
        ArtificialLight currentArtificialLight = artificialLightService.findById(id);
         
        if (currentArtificialLight == null) {
            System.out.println("Artificial Light with id " + id + " not found");
            return new ResponseEntity<ArtificialLight>(HttpStatus.NOT_FOUND);
        }
 
        currentArtificialLight.setGarden(artificialLight.getGarden());
        currentArtificialLight.setDate(artificialLight.getDate());
         
        artificialLightService.saveArtificialLight(currentArtificialLight);
        return new ResponseEntity<ArtificialLight>(currentArtificialLight, HttpStatus.OK);
    }
 
    //------------------- Delete a ArtificialLight --------------------------------------------------------
     
    @RequestMapping(value = "/artificialLight/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ArtificialLight> deleteArtificialLight(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Artificial Light with id " + id);
 
        ArtificialLight artificialLight = artificialLightService.findById(id);
        if (artificialLight == null) {
            System.out.println("Unable to delete. Artificial Light with id " + id + " not found");
            return new ResponseEntity<ArtificialLight>(HttpStatus.NOT_FOUND);
        }
 
        artificialLightService.deleteArtificialLightById(id);
        return new ResponseEntity<ArtificialLight>(HttpStatus.NO_CONTENT);
    }
 
     
    //------------------- Delete All ArtificialLights --------------------------------------------------------
     
    @RequestMapping(value = "/artificialLight/", method = RequestMethod.DELETE)
    public ResponseEntity<ArtificialLight> deleteAllArtificialLights() {
        System.out.println("Deleting All Artificial Lights");
 
        artificialLightService.deleteAllArtificialLights();
        return new ResponseEntity<ArtificialLight>(HttpStatus.NO_CONTENT);
    }
 
}
