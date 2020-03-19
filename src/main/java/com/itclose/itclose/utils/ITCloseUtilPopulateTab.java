package com.itclose.itclose.utils;

import com.itclose.itclose.model.*;
import com.itclose.itclose.repository.*;
import com.itclose.itclose.solr.SolrRefDataServices;
import org.apache.solr.client.solrj.SolrServerException;
import java.io.IOException;
import java.util.Date;

public class ITCloseUtilPopulateTab {


    public ITCloseUtilPopulateTab(IRefDataRepository dao) throws IOException, SolrServerException {
        RefData myData = new RefData();
        myData.setCategorieReferentiel("Entreprise");
        myData.setNomStructure("IT-Close");
        myData.setNomPrenomResponsable("Samuel DIMALE");
        myData.setDateCreation("12/03/1990");
        myData.setPays("Cameroun");
        myData.setVille("Douala");
        myData.setQuartier("Bonaprizo");
        myData.setAdresse("10 boulevard Felix Eboué");
        myData.setRue("boulevard Felix Eboué");
        myData.setTelephone("+ 239 662 330 399");
        myData.setEmail("info-contact@it-close.com");
        myData.setSiteWeb("http://www.it-close.org");
        myData.setSecteurActivite("High Tech");
        myData.setStatutJuridique("SARL");
        myData.setRegimeFiscal("IS");

        //Save in the DB
        dao.save(myData);

        //Save in Solr
        SolrRefDataServices.addRefData(myData);
    }
}
