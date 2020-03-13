package com.itclose.itclose.controller;

import com.itclose.itclose.solr.SolrRefDataServices;
import com.itclose.itclose.model.RefData;
import com.itclose.itclose.repository.IRefDataRepository;
import com.itclose.itclose.utils.ITCloseUtilPopulateTab;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class RefDataController {

    @Autowired
    private IRefDataRepository dao;

    @RequestMapping(value = "/api/refdata", method = RequestMethod.GET)
    public Iterable<RefData> getAllDataFromRelationalDB() throws IOException, SolrServerException {
        dao.deleteAll();
        this.testPopulate();
        return dao.findAll();
    }

    @RequestMapping(value = "/api/refdata/filter/{filter}", method = RequestMethod.GET)
    public List<RefData> getAllRefDataByFilter(@PathVariable String filter) {

        List<RefData> myData = null ;
        try {
            myData = SolrRefDataServices.getFullRefDataByFilter(filter);
        }
        catch (IOException e) {
            e.printStackTrace();   }
        catch (SolrServerException e) {
            e.printStackTrace();        }

        return myData;
    }

    @PostMapping(value = "/api/refdata/save")
    public RefData createrefData(@Valid @RequestBody RefData rd) {
        return dao.save(rd);
    }

    public void testPopulate() throws IOException, SolrServerException {
        ITCloseUtilPopulateTab util = new ITCloseUtilPopulateTab(dao) ;
    }
}
