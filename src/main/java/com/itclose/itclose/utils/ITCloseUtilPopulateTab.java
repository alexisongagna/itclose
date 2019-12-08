package com.itclose.itclose.utils;

import com.itclose.itclose.model.CentreHospitalier;
import com.itclose.itclose.model.Hotel;
import com.itclose.itclose.repository.ICentreHospitalierRepository;
import com.itclose.itclose.repository.IHotelRepository;
import com.itclose.itclose.solr.SolrJHotelServices;

import java.util.ArrayList;
import java.util.List;

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
}
