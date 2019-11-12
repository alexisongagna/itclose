package com.itclose.itclose.controller;

import com.itclose.itclose.model.CentreHospitalier;
import com.itclose.itclose.repository.ICentreHospitalierRepository;
import com.itclose.itclose.solr.SolrConfig;
import com.itclose.itclose.solr.SolrJCentreHospitalierServices;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@RestController
public class CentreHospitalierController {

    @Autowired
    private ICentreHospitalierRepository dao;

    @RequestMapping(value = "/api/CentresHospitaliers", method = RequestMethod.GET)
    public Iterable<CentreHospitalier> getAllCentreHospitalier() throws IOException, SolrServerException {

        testInsert();

        //Iterable<CentreHospitalier> _centresHospitaliers = dao.findAll();

        SolrDocumentList myQ  = SolrJCentreHospitalierServices.getCentresHospitaliers("*:*");
        System.out.println(myQ.getNumFound());

        List<CentreHospitalier> listCH = SolrJCentreHospitalierServices.getFullCentreHospitaliers(myQ);

        return listCH;
    }

    @RequestMapping(value = "/api/CentresHospitaliers/id/{id}", method = RequestMethod.GET)
    public CentreHospitalier getACentreHospitalierById(@PathVariable int id) {

        return dao.findById(id);
    }

    @RequestMapping(value = "/api/CentresHospitaliers/nom/{nom}", method = RequestMethod.GET)
    public CentreHospitalier getACentreHospitalierByNom(@PathVariable String nom) {

        return dao.findByNom(nom);
    }


    //@RequestMapping(value="/api/SauvegardeCentresHospitaliers" , method=RequestMethod.PUT)
    public void testInsert() throws IOException, SolrServerException {

        List<String>  specialites = new ArrayList<String>();
        specialites.add(new String("Stomatologie"));
        specialites.add(new String("Cancerologie"));
        specialites.add(new String("ORL"));
        specialites.add(new String("Diabétologie"));
        specialites.add(new String("Ophtalmologie"));
        specialites.add(new String("Podologie"));


        String collectionName = new String("centrehospitalier");
        HttpSolrClient solr = SolrConfig.getSolrClient(collectionName);

        SolrJCentreHospitalierServices.deleteCentreHospitalierByQuery("nom","CHU Paris 10");
        SolrJCentreHospitalierServices.deleteCentreHospitalierByQuery("nom","Groupe Hospitalier Paris Saint Joseph");

        CentreHospitalier ch = new CentreHospitalier(
                "Groupe Hospitalier Paris Saint Joseph",
                "12/02/2019",
                "France",
                "Paris",
                "Arrondissement 14",
                "185 Rue Raymond Losserand 75014 Paris Cedex 10",
                "Groupe Hospitalier",
                specialites,
                "01 44 12 33 33",
                "info@hpsj.fr",
                "75014"
        ) ;

        SolrJCentreHospitalierServices.addCentreHospitalier(ch);
        dao.save(ch);


        specialites.remove(1);
        ch = new CentreHospitalier(
                "CHU Paris 10",
                "12/02/1876",
                "France",
                "Paris",
                "Arrondissement 10",
                "1 Rue Raymond Pointcarré 75010",
                "CHU",
                specialites,
                "01 44 12 33 33",
                "contact@chuParis10.fr",
                "75010"
        );

        SolrJCentreHospitalierServices.addCentreHospitalier(ch);
        dao.save(ch);

        SolrDocumentList myQ  = SolrJCentreHospitalierServices.getCentresHospitaliers("*:*");
        System.out.println(myQ.getNumFound());
    }
}