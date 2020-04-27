package com.ruchi.breweriesrestapi;

import java.util.List;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
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
@RequestMapping("/rest/AllBrewies")
public class BreweriesController {

    @Autowired
    BreweriesService service;

    @GetMapping(value = "/heatoas/{breweriesID}", produces = MediaTypes.HAL_JSON_VALUE)
    public Resource retrieveBreweries(@PathVariable("breweriesID") int breweriesID) {
        Resource<Breweries> resouce = new Resource(BreweriesService.getBreweriesByID(breweriesID));

        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(methodOn(this.getClass()).getBreweries());
        resouce.add(linkTo.withRel("getBreweries"));
        return resouce;
    }

    @GetMapping(value = "hateoas", produces = MediaTypes.HAL_JSON_VALUE)
    public Resource<Breweries> getBreweries1() {
        List<Breweries> breweries = service.getAllBreweries();
        for (Breweries brewie : breweries) {
            int brewieId = brewie.getId();
            Link selfLink = ControllerLinkBuilder.linkTo(this.getClass()).slash(brewieId).withSelfRel();
            brewie.add(selfLink);
            ControllerLinkBuilder.linkTo(methodOn(this.getClass()).getBreweries(brewieId));
        }
        Link link = ControllerLinkBuilder.linkTo(this.getClass()).withSelfRel();
        Resource<Breweries> result;
        result= new Resource<Breweries>(breweries, link);
        return result;
    }

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<Breweries> getBreweries() {
        return service.getAllBreweries();

    }

    @GetMapping("/Page/{pageNumber}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<Breweries> getPageOfBreweries(@PathVariable("pageNumber") int pageNumber) {
        int startPageIndex = pageNumber - 1;

        final int PAGESIZE = 5;

        int startIndex = startPageIndex * PAGESIZE;
        int endIndex = startIndex + PAGESIZE;
        return service.getAllBreweries().subList(startIndex, endIndex);
    }

    @GetMapping("/{breweriesID}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Breweries getBreweries(@PathVariable("breweriesID") int breweriesID) {
        //Breweries brewery = service.getBreweriesByID(breweriesID);
        //System.out.println(brewery.getName());
        return service.getBreweriesByID(breweriesID);
    }

    @DeleteMapping("/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public int deleteBreweries(@PathVariable("id") int id) {
        return service.deleteBreweries(id);
    }

    @PostMapping(value = "/Create")
    @ResponseStatus(HttpStatus.CREATED)
    public Breweries create(@RequestBody Breweries b) {
        System.out.println("Inserting");
        return service.InsertBreweries(b);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void Update(@PathVariable("id") int id, @RequestBody Breweries b) {
        service.updateBreweries(id, b);

    }

}

//</editor-fold>

