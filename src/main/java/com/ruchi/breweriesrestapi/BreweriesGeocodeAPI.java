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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ruchi Devi
 */
@RestController
@RequestMapping("/rest/BreweriesGeocode")
public class BreweriesGeocodeAPI {

    @Autowired
    BreweriesGeocodeService Service;

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<BreweriesGeocode> getAllBreweriesGeocode() {
        return Service.getAllBreweriesGeocode();

    }

}
