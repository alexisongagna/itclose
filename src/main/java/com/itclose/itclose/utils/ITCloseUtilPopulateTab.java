package com.itclose.itclose.utils;

import com.itclose.itclose.model.*;
import com.itclose.itclose.repository.*;
import com.itclose.itclose.solr.SolrRefDataServices;
import com.itclose.itclose.solr.SolrRefDataServices.*;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ITCloseUtilPopulateTab {



    public ITCloseUtilPopulateTab(ICentreHospitalierRepository dao)
    {
        dao.deleteAll();

        List<String> specialites = new ArrayList<String>();
        specialites.add(new String("Stomatologie"));
        specialites.add(new String("Cancerologie"));
        specialites.add(new String("ORL"));
        specialites.add(new String("Diabétologie"));
        specialites.add(new String("Ophtalmologie"));
        specialites.add(new String("Podologie"));


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

        dao.save(ch);

        specialites.remove(3);
        specialites.add(new String("Chirurgie dentaire"));
        specialites.add(new String("Gynéchologie"));
        ch = new CentreHospitalier(
                "Clinique des Franciscaines",
                "20/09/1945",
                "France",
                "Versailles",
                "Versailles Chantier",
                "128 avenue de la république 78000 Versailles",
                "Clinique",
                specialites,
                "01 48 11 90 90",
                "info@cfranciscaines.org",
                "78000"
        );

        dao.save(ch);
    }

    public ITCloseUtilPopulateTab(IHotelRepository dao)
    {
        dao.deleteAll();

        Hotel hotel_1 = new Hotel(
                "La TDH - Hotel & Restaurant",
                "France",
                "Fontenay sous bois",
                "Val de Fontenay",
                "Avenue du maréchal de lattre de tassigny",
                2017,
                1,
                "01 45 34 21 10",
                "contact@gmail.com",
                "www.la-table-dhome.fr"
        ) ;

        dao.save(hotel_1);

        Hotel hotel_2 = new Hotel(
                "Au petit matin",
                "France",
                "Paris",
                "Moulin rouge",
                "87 avenue de Versailles",
                2019,
                3,
                "01 48 90 21 10",
                "contact@aupetitmatin.com",
                "www.ta-table-dhome.fr"
        ) ;

        dao.save(hotel_2);

        Hotel hotel_3 = new Hotel(
                "Chez la Mama",
                "France",
                "Pantin",
                "",
                "6 rue Hector Berlioz",
                2011,
                2,
                "01 45 34 21 10",
                "contact@clamama.com",
                "www.chez-la-mama.com"
        ) ;

        dao.save(hotel_3);
    }


    public ITCloseUtilPopulateTab(IRestaurantRepository dao)
    {
        dao.deleteAll();

        List<String> specialites = new ArrayList<String>();
        specialites.add(new String("Cuisine africaine"));
        specialites.add(new String("Cuisine française"));
        specialites.add(new String("Specialités turques"));


        Restaurant hotel_1 = new Restaurant(
                "La TDH - Hotel & Restaurant",
                "France",
                "Fontenay sous bois",
                "Val de Fontenay",
                "Avenue du maréchal de lattre de tassigny",
                2017,
                1,
                specialites,
                "01 45 34 21 10",
                "contact@gmail.com",
                "www.la-table-dhome.fr"
        ) ;

        dao.save(hotel_1);

        specialites.remove(1);
        Restaurant hotel_2 = new Restaurant(
                "Au petit matin",
                "France",
                "Paris",
                "Moulin rouge",
                "87 avenue de Versailles",
                2019,
                3,
                specialites,
                "01 48 90 21 10",
                "contact@aupetitmatin.com",
                "www.ta-table-dhome.fr"
        ) ;

        dao.save(hotel_2);

        specialites.remove(1);
        Restaurant hotel_3 = new Restaurant(
                "Chez la Mama",
                "France",
                "Pantin",
                "",
                "6 rue Hector Berlioz",
                2011,
                2,
                specialites,
                "01 45 34 21 10",
                "contact@clamama.com",
                "www.chez-la-mama.com"
        ) ;

        dao.save(hotel_3);
    }

    public ITCloseUtilPopulateTab(IEntrepriseRepository dao)
    {
        dao.deleteAll();

        Entreprise ent = new Entreprise(
                "France",
                "Banque / Finance / Assurance",
                "FinDb Consulting",
                2017,
                "SARL",
                "Impôt sur les sociétés",
                "www.FinDB-Cons.org"
        ) ;

        dao.save(ent);
    }

    public ITCloseUtilPopulateTab(IRefDataRepository dao) throws IOException, SolrServerException {
        RefData myData = new RefData();
        myData.setCategorieReferentiel("Entreprise");
        myData.setNomStructure("IT-Close");
        myData.setNomPrenomResponsable("Samuel DIMALE");
        myData.setDateCreation(new Date());
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
        dao.save(myData);
        SolrRefDataServices.addRefData(myData);
    }
}
