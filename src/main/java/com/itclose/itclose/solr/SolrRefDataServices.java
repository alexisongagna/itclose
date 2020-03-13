package com.itclose.itclose.solr;

import com.itclose.itclose.model.RefData;
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
import java.util.Date;

public class SolrRefDataServices {


    private final static String COLLECTION_NAME = "RefData";
    private final static String RESPONSE = "response";
    private final static String SOLR_Q_KEY = "q";
    private final static String SOLR_WT_KEY = "wt" ;
    private final static String SOLR_WT_VALUE = "json" ;


    //Common fields
    private final static String IDENTIFIER          = "id";
    private final static String CATEGORIE_REF       = "categoriereferentiel" ;
    private final static String NOM_STRUCTURE       = "nomstructure" ;
    private final static String NOM_RESPONSABLE     = "nomprenomresponsable" ;
    private final static String DATE_CREATION       = "datecreation" ;
    private final static String PAYS                = "pays" ;
    private final static String VILLE               = "ville" ;
    private final static String QUARTIER            = "quartier" ;
    private final static String ADRESSE             = "adresse" ;
    private final static String RUE                 = "rue" ;
    private final static String TELEPHONE           = "telephone" ;
    private final static String EMAIL               = "email" ;
    private final static String SITE_WEB            = "siteweb" ;
    private final static String BOITE_POSTALE       = "boitepostale" ;

    //Fields for CentreHospitaliers
    private final static String TYPE_CENTRE_HOSPITALIER =   "typecentrehospitalier" ;
    private final static String SPECIALITE_CH       = "specialites" ;

    //Common Fields for Restaurant and Hotel
    private final static String NB_ETOILES          = "nbetoile" ;
    private final static String TYPE_PLATS          = "typesplats" ;


    //Fields for Entreprise
    private final static String SECTEUR_ACTIVITE    = "secteuractivite" ;
    private final static String STATUT_JURIDIQUE    = "statutjuridique" ;
    private final static String REGIME_FISCAL       = "regimefiscal" ;

    //Fields for Assurance
    private final static String ASSUREUR            = "assureur" ;
    private final static String PRIME               = "prime" ;
    private final static String VALEUR_PRIME        = "valeurprime" ;
    private final static String DUREE_PRIME         = "dureeprime";

    //Fields for TransporteurTerrestre
    private final static String TYPE_VEHICULE       = "typevehicule" ;
    private final static String AGENT_RAVITO        = "agentravitocarburant" ;

    //Fields for TransporteurAerien
    private final static String TYPE_AVION          = "typeavion" ;
    private final static String NB_PILOTES          = "nbpilotes" ;



    public static void addRefData(RefData pBean) throws IOException, SolrServerException {

        HttpSolrClient solrClient = new SolrConfig().getSolrClient(COLLECTION_NAME);
        solrClient.addBean(pBean);
        solrClient.commit();
    }

    public static SolrDocumentList getRefDataDocumentFromSolrByFilter(String filter) throws IOException, SolrServerException {


        HttpSolrClient solrClient = new SolrConfig().getSolrClient(COLLECTION_NAME);

        final Map<String, String> queryParamMap = new HashMap<String, String>();
        queryParamMap.put(SOLR_Q_KEY, filter);
        queryParamMap.put(SOLR_WT_KEY, SOLR_WT_VALUE);
        MapSolrParams queryParams = new MapSolrParams(queryParamMap);

        final QueryResponse response = solrClient.query(queryParams);
        final SolrDocumentList documents = response.getResults();

        return documents;
    }

    public static List<RefData> getFullRefDataByFilter(String filter) throws IOException, SolrServerException {

        SolrDocumentList documents = getRefDataDocumentFromSolrByFilter(filter);

        List<RefData> myList = new ArrayList<RefData>();

        if(documents.getNumFound() > 0) {
            for (SolrDocument aDoc : documents)
            {
                String categorie = (String)aDoc.getFieldValue(CATEGORIE_REF);

                RefData myData = new RefData();

                //myData.setId((int)aDoc.getFieldValue(IDENTIFIER)) ;
                myData.setCategorieReferentiel(categorie) ;
                myData.setNomStructure((String)aDoc.getFieldValue(NOM_STRUCTURE));
                myData.setNomPrenomResponsable((String)aDoc.getFieldValue(NOM_RESPONSABLE));
                myData.setDateCreation((Date)aDoc.getFieldValue(DATE_CREATION));
                myData.setNomPrenomResponsable((String)aDoc.getFieldValue(NOM_RESPONSABLE));
                myData.setPays((String)aDoc.getFieldValue(PAYS));
                myData.setVille((String)aDoc.getFieldValue(VILLE));
                myData.setQuartier((String)aDoc.getFieldValue(QUARTIER));
                myData.setAdresse((String)aDoc.getFieldValue(ADRESSE));
                myData.setRue((String)aDoc.getFieldValue(RUE));
                myData.setTelephone((String)aDoc.getFieldValue(TELEPHONE));
                myData.setEmail((String)aDoc.getFieldValue(EMAIL));
                myData.setSiteWeb((String)aDoc.getFieldValue(SITE_WEB));
                myData.setBoitePostale((String)aDoc.getFieldValue(BOITE_POSTALE));

                if(!categorie.isEmpty() && categorie.equals("Centre_Hospitalier")) {
                    myData.setTypeCentreHospitalier((String) aDoc.getFieldValue(TYPE_CENTRE_HOSPITALIER));
                    myData.setSpecialites((String) aDoc.getFieldValue(SPECIALITE_CH));
                }
                else  if(!categorie.isEmpty() && categorie.equals("Hotel")) {
                    myData.setNbEtoile((int) aDoc.getFieldValue(NB_ETOILES));
                    myData.setTypesPlats((String) aDoc.getFieldValue(TYPE_PLATS));
                }
                else if(!categorie.isEmpty() && categorie.equals("Restaurant")) {
                    myData.setNbEtoile((int) aDoc.getFieldValue(NB_ETOILES));
                }
                else if(!categorie.isEmpty() && categorie.equals("Entreprise")) {
                    myData.setSecteurActivite((String) aDoc.getFieldValue(SECTEUR_ACTIVITE));
                    myData.setStatutJuridique((String) aDoc.getFieldValue(STATUT_JURIDIQUE));
                    myData.setRegimeFiscal((String) aDoc.getFieldValue(REGIME_FISCAL));
                }
                else if(!categorie.isEmpty() && categorie.equals("Assurance")) {
                    myData.setAssureur((String) aDoc.getFieldValue(ASSUREUR));
                    myData.setPrime((float) aDoc.getFieldValue(PRIME));
                    myData.setDureePrime((int) aDoc.getFieldValue(DUREE_PRIME));
                }
                else  if(!categorie.isEmpty() && categorie.equals("Transporteur_Terrestre")) {
                    myData.setTypeVehicule((String) aDoc.getFieldValue(TYPE_VEHICULE));
                    myData.setAgentRavitoCarburant((String) aDoc.getFieldValue(AGENT_RAVITO));
                }
                else  if(!categorie.isEmpty() && categorie.equals("Transporteur_Aerien")) {
                    myData.setTypeAvion((String) aDoc.getFieldValue(TYPE_AVION));
                    myData.setNbPilotes((int) aDoc.getFieldValue(NB_PILOTES));
                }

                myList.add(myData);
                myData = null ;
            }
        }
        return myList ;
    }

}
