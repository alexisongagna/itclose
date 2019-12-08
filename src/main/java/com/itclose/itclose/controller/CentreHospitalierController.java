package com.itclose.itclose.controller;

import com.itclose.itclose.utils.ITCloseUtilPopulateTab;
import com.itclose.itclose.model.CentreHospitalier;
import com.itclose.itclose.repository.ICentreHospitalierRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.io.IOException;


@RestController
@Tag(name = "CentreHospitalier", description = "Les API dédiés aux centres hospitaliers")
public class CentreHospitalierController {

    @Autowired
    private ICentreHospitalierRepository dao;

    @RequestMapping(value = "/api/CentresHospitaliers", method = RequestMethod.GET)
    @Operation(summary = "Restitution de l'ensemble des centres hospitaliers", description = "Aucun paramètre d'entrée", tags = { "CentreHospitalier" })
    public Iterable<CentreHospitalier> getAllCentreHospitalier() throws IOException {
        testPopulate();
        return dao.findAll();
    }

    @RequestMapping(value = "/api/CentresHospitaliers/id/{id}", method = RequestMethod.GET)
    @Operation(summary = "Restitution d'un centre hospitalier à partir de son identifiant technique", description = "Paramètre d'entrée : l'indentifiant", tags = { "CentreHospitalier" })
    public CentreHospitalier getACentreHospitalierById(@PathVariable int id) {
        return dao.findById(id);
    }

    @RequestMapping(value = "/api/CentresHospitaliers/nom/{nom}", method = RequestMethod.GET)
    @Operation(summary = "Restitution d'un centre hospitalier à partir de son nom", description = "Paramètre d'entrée : le nom du centre hospitalier", tags = { "CentreHospitalier" })
    public CentreHospitalier getACentreHospitalierByNom(@PathVariable String nom) {
        return dao.findByNom(nom);
    }

    @PostMapping(value = "/api/CentresHospitaliers/save")
    @Operation(summary = "Enregistrement ou mise à jour d'un centre hospitalier dans le référentiel", description = "Paramètres d'entrée : l'ensemble des informations descriptives du centre hospitalier", tags = { "CentreHospitalier" })
    public CentreHospitalier createCentreHospitalier(@Valid @RequestBody CentreHospitalier ch) {
        return dao.save(ch);
    }


    @DeleteMapping("/api/CentresHospitaliers/delete/id/{id}")
    @Operation(summary = "Suppression d'un centre hospitalier dans le référentiel", description = "Paramètres d'entrée : le nom ou l'identifiant technique du centre hospitalier", tags = { "CentreHospitalier" })
    public ResponseEntity<?> deleteCentreHospitalier(@PathVariable int id, @PathVariable String nom) {

        CentreHospitalier ch = null ;

        if(id > 0)
        {
            ch = dao.findById(id);
        }
        else if (nom != null)
        {
            ch = dao.findByNom(nom);
        }

        dao.delete(ch);

        return ResponseEntity.ok().build();
    }



    public void testPopulate() throws IOException {
        ITCloseUtilPopulateTab util = new ITCloseUtilPopulateTab(dao) ;
    }
}