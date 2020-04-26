/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruchi.breweriesrestapi;

import java.awt.print.Pageable;
import java.security.Provider.Service;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ruchi Devi
 */
@RestController
@RequestMapping("/AllBrewies")
public class BreweriesController {

    @Autowired
    BreweriesService Service;
    
    /**
     *
     * @param breweriesID
     * @return
     */
    @GetMapping(value ="/heatoas/{breweriesID}",produces = MediaTypes.HAL_JSON_VALUE)
    
    public Resource<Breweries> retrieveBreweries(@PathVariable("breweriesID") int breweriesID) {
        Resource<Breweries> resouce = new Resource<Breweries>(BreweriesService.getBreweriesByID(breweriesID));

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass.()).getBreweries()
        );
       resouce.add(linkTo.withRel("getBreweries"));
        return resouce;
    }      
    

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<Breweries> getBreweries() {
        return Service.getAllBreweries();

    }

    @GetMapping("/{breweriesID}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Breweries getBreweries(@PathVariable("breweriesID")int breweriesID){        
        //Breweries brewery = Service.getBreweriesByID(breweriesID);
        //System.out.println(brewery.getName());
       return Service.getBreweriesByID(breweriesID);
    }    
    @DeleteMapping("/{id}")
     @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public int deleteBreweries(@PathVariable("id")int id){
        return Service.deleteBreweries(id);
    }     
    @PostMapping(value = "/Create")
    @ResponseStatus(HttpStatus.CREATED)
    public Breweries create(@RequestBody Breweries b) {
        System.out.println("Inserting");
        return Service.InsertBreweries(b);
    }          
    
    @PutMapping(value = "/{id}")
     @ResponseStatus(HttpStatus.OK) 
	public void Update(@PathVariable("id")int id, @RequestBody Breweries b) {
		Service.updateBreweries(id, b);
                
        }

    private class getClass {

        public getClass() {
        }
    }
        
}   
     
  

    



//</editor-fold>
      
                 
    
    

