package com.markuu.demo.repo;

import com.markuu.demo.models.Hospitalization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalizationRepository extends CrudRepository<Hospitalization, Long> {

    @Query("SELECT u FROM Hospitalization u")
    List<Hospitalization> findAll();



}
