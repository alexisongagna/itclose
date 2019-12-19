package com.itclose.itclose.repository;

import com.itclose.itclose.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface IRestaurantRepository extends CrudRepository<Restaurant, Long>{

    Restaurant findById(int id);

    Restaurant findByNom(String nom);

    List<Restaurant> findByAnneeCreation(int anneeCreation);

    List<Restaurant> findByNbEtoile(int nbEtoile);

    List<Restaurant> findAll();

}
