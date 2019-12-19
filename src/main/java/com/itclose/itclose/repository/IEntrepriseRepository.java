package com.itclose.itclose.repository;

import com.itclose.itclose.model.Entreprise;
import com.itclose.itclose.model.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEntrepriseRepository extends CrudRepository<Entreprise, Long> {

    Hotel findById(int id);

    Hotel findByNom(String nom);

    List<Entreprise> findBySecteurActivite(String secteurActivite);

    List<Entreprise> findByAnneeCreation(int anneeCreation);

    List<Entreprise> findByStatutJuridique(String statutJuridique);

    List<Entreprise> findAll();
}