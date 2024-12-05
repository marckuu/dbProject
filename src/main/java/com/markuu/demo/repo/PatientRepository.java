package com.markuu.demo.repo;

import com.markuu.demo.models.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Query("SELECT u FROM Patient u")
    List<Patient> findAll();



}
