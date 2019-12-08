package com.itclose.itclose.controller;

import com.itclose.itclose.utils.ITCloseUtilPopulateTab;
import com.itclose.itclose.model.Hotel;
import com.itclose.itclose.repository.IHotelRepository;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class HotelController {

    @Autowired
    private IHotelRepository dao;

    @RequestMapping(value = "/api/Hotels", method = RequestMethod.GET)
    public Iterable<Hotel> getAllHotels() throws IOException, SolrServerException {

        testPopulate();
        return dao.findAll();
    }

    @RequestMapping(value = "/api/Hotels/id/{id}", method = RequestMethod.GET)
    public Hotel getAHotelById(@PathVariable int id) {
        return dao.findById(id);
    }

    @RequestMapping(value = "/api/Hotels/nom/{nom}", method = RequestMethod.GET)
    public Hotel getAHotelByNom(@PathVariable String nom) {
        return dao.findByNom(nom);
    }

    @PostMapping(value = "/api/Hotels/save")
    public Hotel createHotel(@Valid @RequestBody Hotel ch) {
        return dao.save(ch);
    }

    public void testPopulate() throws IOException, SolrServerException {
        ITCloseUtilPopulateTab util = new ITCloseUtilPopulateTab(dao) ;
    }
}
