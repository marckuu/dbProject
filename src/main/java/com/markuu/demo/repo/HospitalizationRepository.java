package com.markuu.demo.repo;

import com.markuu.demo.models.Hospitalization;
import com.markuu.demo.models.Patient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Repository
public interface HospitalizationRepository extends CrudRepository<Hospitalization, Long> {

    @Query("SELECT u FROM Hospitalization u")
    List<Hospitalization> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Hospitalization SET Hosp_data = :Hosp_data, Hosp_time = :Hosp_time, Hosp_reason = :Hosp_reason, " +
            "patient.id = :patientId WHERE id = :id")
    void set(@Param("Hosp_data") Date Hosp_data,
             @Param("Hosp_time") Time Hosp_time,
             @Param("Hosp_reason") String Hosp_reason,
             @Param("patientId") Long patientId,
             @Param("id") Long id);



}
