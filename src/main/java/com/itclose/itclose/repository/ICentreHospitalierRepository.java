package com.itclose.itclose.repository;

import com.itclose.itclose.model.CentreHospitalier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ICentreHospitalierRepository extends CrudRepository<com.itclose.itclose.model.CentreHospitalier, Long> {

    CentreHospitalier findById(int id);

    CentreHospitalier findByNom(String nom);

    List<CentreHospitalier> findBySpecialites(String specialites);

    List<CentreHospitalier> findAll();


}
