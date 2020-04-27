/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruchi.breweriesrestapi;

import java.util.List;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 *
 * @author Ruchi Devi
 */
 @RequestMapping("/AllBeer")
public class BeerAPI {
   @Autowired
   BeersService Service;
   @GetMapping
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<Beers> getBeers() {
        return Service.getAllBeers();

    }
     @GetMapping("/{BeersID}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Beers getBeers(@PathVariable("BeersID")int beersID){        
        //Breweries brewery = Service.getBreweriesByID(breweriesID);
        //System.out.println(brewery.getName());
       return Service.getBeersByID(beersID);
    }
     @DeleteMapping("/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public int deleteBeers(@PathVariable("id") int id) {
        return Service.deleteBeers(id);
    }
    
    @PostMapping(value = "/Save")
    @ResponseStatus(HttpStatus.CREATED)
    public Beers create(@RequestBody Beers b) {
        System.out.println("Inserting");
        return Service.InsertBeers(b);
    }
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void Update(@PathVariable("id") int id, @RequestBody Beers b) {
        Service.UpdateBeers(id, b);
    
}
}
    

