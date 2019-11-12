package com.itclose.itclose.solr;

import com.itclose.itclose.model.CentreHospitalier;
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


public class SolrJCentreHospitalierServices {

    private final static String COLLECTION_NAME = "centrehospitalier";
    private final static String RESPONSE = "response";
    private final static String SOLR_Q_KEY = "q";
    private final static String SOLR_SORT_KEY = "sort" ;
    private final static String SOLR_SORT_VALUE = "nom asc";
    private final static String SOLR_WT_KEY = "wt" ;
    private final static String SOLR_WT_VALUE = "json" ;

   //final static Logger logger = Logger.getLogger(classname.class);


    public static void addCentreHospitalier(CentreHospitalier pBean) throws IOException, SolrServerException {

        HttpSolrClient solrClient = new SolrConfig().getSolrClient(COLLECTION_NAME);
        solrClient.addBean(pBean);
        solrClient.commit();
    }

    public static SolrDocumentList getCentresHospitaliers(String filter) throws IOException, SolrServerException {


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

    public void deleteCentreHospitalierById(String documentId) throws SolrServerException, IOException {

        HttpSolrClient solrClient = new SolrConfig().getSolrClient(COLLECTION_NAME);
        solrClient.deleteById(documentId);
        solrClient.commit();
    }

    public static void deleteCentreHospitalierByQuery(String field, String value) throws SolrServerException, IOException {

        HttpSolrClient solrClient = new SolrConfig().getSolrClient(COLLECTION_NAME);
        solrClient.deleteByQuery(field+":"+value);
        solrClient.commit();
    }

    public static List<CentreHospitalier> getFullCentreHospitaliers(SolrDocumentList documents)
    {
        List<CentreHospitalier> myList = new ArrayList<CentreHospitalier>();

        if(documents.getNumFound() > 0) {
            for (SolrDocument aDoc : documents) {
                CentreHospitalier centreHospitalier = new CentreHospitalier();
                centreHospitalier.setNom((String) aDoc.getFieldValue("nom"));
                centreHospitalier.setCreation((String) aDoc.getFieldValue("creation"));
                centreHospitalier.setPays((String) aDoc.getFieldValue("pays"));
                centreHospitalier.setVille((String) aDoc.getFieldValue("ville"));
                centreHospitalier.setQuartier((String) aDoc.getFieldValue("quartier"));
                centreHospitalier.setAdresse((String) aDoc.getFieldValue("adresse"));
                centreHospitalier.setTypeCentreHospitalier((String) aDoc.getFieldValue("typeCentreHospitalier"));
                centreHospitalier.setSpecialites((String) aDoc.getFieldValue("specialites"));
                centreHospitalier.setTelephone((String) aDoc.getFieldValue("telephone"));
                centreHospitalier.setEmail((String) aDoc.getFieldValue("email"));

                Long bP = (Long) aDoc.getFieldValue("boitePostale");
                centreHospitalier.setBoitePostale(bP.toString());

                myList.add(centreHospitalier);
                centreHospitalier = null ;
            }
        }
        return myList ;
    }
}

