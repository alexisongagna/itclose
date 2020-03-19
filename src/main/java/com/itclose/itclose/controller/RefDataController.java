package com.itclose.itclose.controller;

import com.itclose.itclose.model.RefData;
import com.itclose.itclose.repository.IRefDataRepository;
import com.itclose.itclose.solr.SolrRefDataServices;
import com.itclose.itclose.utils.ITCloseUtilPopulateTab;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class RefDataController {

    @Autowired
    private IRefDataRepository dao;


    @RequestMapping(value = "/refdata/documents", method = RequestMethod.GET)
    public Iterable<RefData> getAllDataFromRelationalDB() throws IOException, SolrServerException {
        dao.deleteAll();
        this.testPopulate();
        return dao.findAll();
    }

    @RequestMapping(value = "/refdata/filter/{filter}", method = RequestMethod.GET)
    public List<RefData> getAllRefDataByFilter(@PathVariable String filter) throws IOException, SolrServerException {
       return SolrRefDataServices.getFullRefDataByFilter(filter);
    }


    @RequestMapping(value = "/refdata/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void createrefData(@RequestBody RefData rd) throws IOException, SolrServerException{
        SolrRefDataServices.addRefData(rd);
    }

    public void testPopulate() throws IOException, SolrServerException {
        ITCloseUtilPopulateTab util = new ITCloseUtilPopulateTab(dao) ;
    }
}
