package com.itclose.itclose.controller;
import com.itclose.itclose.model.Entreprise;
import com.itclose.itclose.repository.IEntrepriseRepository;
import com.itclose.itclose.utils.ITCloseUtilPopulateTab;
import com.itclose.itclose.model.Hotel;
import com.itclose.itclose.repository.IHotelRepository;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class EntrepriseController {

    @Autowired
    private IEntrepriseRepository dao;

    @RequestMapping(value = "/api/Entreprises", method = RequestMethod.GET)
    public Iterable<Entreprise> getAllEntreprises() throws IOException, SolrServerException {

        testPopulate();
        return dao.findAll();
    }

    @RequestMapping(value = "/api/Entreprises/id/{id}", method = RequestMethod.GET)
    public Hotel getEntrepriseById(@PathVariable int id) {
        return dao.findById(id);
    }

    @RequestMapping(value = "/api/Entreprises/nom/{nom}", method = RequestMethod.GET)
    public Hotel getEntrepriseByNom(@PathVariable String nom) {
        return dao.findByNom(nom);
    }

    @PostMapping(value = "/api/Entreprises/save")
    public Entreprise createEntreprise(@Valid @RequestBody Entreprise ch) {
        return dao.save(ch);
    }

    public void testPopulate() throws IOException, SolrServerException {
        ITCloseUtilPopulateTab util = new ITCloseUtilPopulateTab(dao) ;
    }
}
