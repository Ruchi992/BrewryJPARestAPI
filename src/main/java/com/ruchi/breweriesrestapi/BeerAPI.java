/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruchi.breweriesrestapi;

import java.util.List;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ruchi Devi
 */
@RestController
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
    
}
