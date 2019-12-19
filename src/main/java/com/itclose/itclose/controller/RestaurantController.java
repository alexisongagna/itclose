package com.itclose.itclose.controller;

import com.itclose.itclose.model.Restaurant;
import com.itclose.itclose.repository.IRestaurantRepository;
import com.itclose.itclose.utils.ITCloseUtilPopulateTab;
import com.itclose.itclose.model.Hotel;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController

public class RestaurantController {

    @Autowired
    private IRestaurantRepository dao;

    @RequestMapping(value = "/api/Restaurants", method = RequestMethod.GET)
    public Iterable<Restaurant> getAllRestaurants() throws IOException, SolrServerException {

        testPopulate();
        return dao.findAll();
    }

    @RequestMapping(value = "/api/Restaurants/id/{id}", method = RequestMethod.GET)
    public Restaurant getRestaurantById(@PathVariable int id) {
        return dao.findById(id);
    }

    @RequestMapping(value = "/api/Restaurants/nom/{nom}", method = RequestMethod.GET)
    public Restaurant getRestaurantByNom(@PathVariable String nom) {
        return dao.findByNom(nom);
    }

    @PostMapping(value = "/api/Restaurants/save")
    public Restaurant createRestaurant(@Valid @RequestBody Restaurant ch) {
        return dao.save(ch);
    }

    public void testPopulate() throws IOException, SolrServerException {
        ITCloseUtilPopulateTab util = new ITCloseUtilPopulateTab(dao) ;
    }
}
