package com.itclose.itclose.controller;

import com.itclose.itclose.model.CentreHospitalier;
import com.itclose.itclose.model.Hotel;
import com.itclose.itclose.repository.ICentreHospitalierRepository;
import com.itclose.itclose.repository.IHotelRepository;
import com.itclose.itclose.solr.SolrConfig;
import com.itclose.itclose.solr.SolrJCentreHospitalierServices;
import com.itclose.itclose.solr.SolrJHotelServices;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private IHotelRepository dao;

    @RequestMapping(value = "/api/Hotels", method = RequestMethod.GET)
    public Iterable<Hotel> getAllHotels() throws IOException, SolrServerException {

        testInsert();

        SolrDocumentList myQ  = SolrJHotelServices.getHotels("*:*");
        System.out.println(myQ.getNumFound());

        List<Hotel> listHotels = SolrJHotelServices.getFullHotel(myQ);

        return listHotels;
    }

    public void testInsert() throws IOException, SolrServerException {


        String collectionName = new String("hotel");
        HttpSolrClient solr = SolrConfig.getSolrClient(collectionName);

      //  SolrJHotelServices.deleteHotelByQuery("nom","La TDH");
       // SolrJHotelServices.deleteHotelByQuery("nom","Chez la Mama");

        Hotel hotel_1 = new Hotel(
                "La TDH",
                "France",
                "Fontenay sous bois",
                "Val de Fontenay",
                "Avenue du maréchal de lattre de tassigny",
                2017,
                1,
                "01 45 34 21 10",
                "contact@gmail.com",
                "www.ta-table-dhome.fr"
        ) ;

        SolrJHotelServices.addHotel(hotel_1);
        dao.save(hotel_1);

        Hotel hotel_2 = new Hotel(
                "Chez la Mama",
                "France",
                "Fontenay sous bois",
                "Val de Fontenay",
                "Avenue du maréchal de lattre de tassigny",
                2017,
                1,
                "01 45 34 21 10",
                "contact@gmail.com",
                "www.ta-table-dhome.fr"
        ) ;

        SolrJHotelServices.addHotel(hotel_2);
        dao.save(hotel_2);

    }
}
