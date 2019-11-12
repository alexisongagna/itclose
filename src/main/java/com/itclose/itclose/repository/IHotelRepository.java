package com.itclose.itclose.repository;

import com.itclose.itclose.model.CentreHospitalier;
import com.itclose.itclose.model.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHotelRepository extends CrudRepository<Hotel, Long> {

    Hotel findById(int id);

    Hotel findByNom(String nom);

    List<Hotel> findByAnneeCreation(int anneeCreation);

    List<Hotel> findByNbEtoile(int nbEtoile);

    List<Hotel> findAll();
}
