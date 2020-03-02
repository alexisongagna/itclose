package com.itclose.itclose.repository;

import com.itclose.itclose.model.RefData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRefDataRepository extends CrudRepository<RefData, Long> {

    RefData findById(int id);

    RefData findByCategorieReferentiel(String categorieReferentiel);

    List<RefData> findAll();

}
