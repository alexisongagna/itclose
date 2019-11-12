package com.itclose.itclose.solr;

import com.itclose.itclose.model.CentreHospitalier;
import com.itclose.itclose.model.Hotel;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SolrJHotelServices {

    private final static String COLLECTION_NAME = "hotel";
    private final static String RESPONSE = "response";
    private final static String SOLR_Q_KEY = "q";
    private final static String SOLR_SORT_KEY = "sort" ;
    private final static String SOLR_SORT_VALUE = "nom asc";
    private final static String SOLR_WT_KEY = "wt" ;
    private final static String SOLR_WT_VALUE = "json" ;

   //final static Logger logger = Logger.getLogger(classname.class);


    public static void addHotel(Hotel pBean) throws IOException, SolrServerException {

        HttpSolrClient solrClient = new SolrConfig().getSolrClient(COLLECTION_NAME);
        solrClient.addBean(pBean);
        solrClient.commit();
    }

    public static SolrDocumentList getHotels(String filter) throws IOException, SolrServerException {


        HttpSolrClient solrClient = new SolrConfig().getSolrClient(COLLECTION_NAME);

        final Map<String, String> queryParamMap = new HashMap<String, String>();
        queryParamMap.put(SOLR_Q_KEY, filter);
        //queryParamMap.put(SOLR_SORT_KEY, SOLR_SORT_VALUE);
        queryParamMap.put(SOLR_WT_KEY, SOLR_WT_VALUE);
        MapSolrParams queryParams = new MapSolrParams(queryParamMap);

        final QueryResponse response = solrClient.query(queryParams);
        final SolrDocumentList documents = response.getResults();

        return documents;

    }

    public void deleteHotelById(String documentId) throws SolrServerException, IOException {

        HttpSolrClient solrClient = new SolrConfig().getSolrClient(COLLECTION_NAME);
        solrClient.deleteById(documentId);
        solrClient.commit();
    }

    public static void deleteHotelByQuery(String field, String value) throws SolrServerException, IOException {

        HttpSolrClient solrClient = new SolrConfig().getSolrClient(COLLECTION_NAME);
        solrClient.deleteByQuery(field+":"+value);
        solrClient.commit();
    }

    public static List<Hotel> getFullHotel(SolrDocumentList documents)
    {
        List<Hotel> myList = new ArrayList<Hotel>();

        if(documents.getNumFound() > 0) {
            for (SolrDocument aDoc : documents) {
                Hotel hotel = new Hotel();
                hotel.setNom((String) aDoc.getFieldValue("nom"));
                hotel.setPays((String) aDoc.getFieldValue("pays"));
                hotel.setVille((String) aDoc.getFieldValue("ville"));
                hotel.setQuartier((String) aDoc.getFieldValue("quartier"));
                hotel.setRue((String) aDoc.getFieldValue("rue"));

                Long creation = (Long) aDoc.getFieldValue("anneecreation");
                hotel.setAnneeCreation(creation.intValue());

                Long nbEtoile = (Long) aDoc.getFieldValue("nbetoile");
                hotel.setNbEtoile(nbEtoile.intValue());

                hotel.setTelephone((String) aDoc.getFieldValue("telephone"));
                hotel.setEmail((String) aDoc.getFieldValue("email"));
                hotel.setSiteWeb((String) aDoc.getFieldValue("siteweb"));

                myList.add(hotel);
                hotel = null ;
            }
        }
        return myList ;
    }
}

