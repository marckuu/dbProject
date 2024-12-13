package com.markuu.demo.repo;

import com.markuu.demo.models.Child;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public interface ChildRepository extends CrudRepository<Child, Long> {

    @Query("SELECT u FROM Child u")
    List<Child> findAll();


    @Modifying
    @Transactional
    @Query("UPDATE Child SET first_name = :firstName, middle_name = :middleName, last_name = :lastName, " +
            "height = :height, weight = :weight, gender = :gender, pathologies = :pathologies, ward.id = :ward, " +
            "patient.id = :mother, birth_date = :birthDate WHERE id = :id")
    void set(@RequestParam String firstName,
             @RequestParam String middleName,
             @RequestParam String lastName,
             @RequestParam int height,
             @RequestParam int weight,
             @RequestParam String gender,
             @RequestParam String pathologies,
             @RequestParam Long ward,
             @RequestParam Date birthDate,
             @RequestParam Long mother,
             @RequestParam Long id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Child (id, first_name, middle_name, last_name, birth_date, height, weight, gender, pathologies, patient_id, ward_id)" +
            "VALUES (:id, :first_name, :middle_name, :last_name, :birth_date, :height, :weight, :gender, :pathologies, :patient_id, :ward_id)", nativeQuery = true)
    void addChild(@Param("id") Long id,
                   @Param("first_name") String first_name,
                   @Param("middle_name") String middle_name,
                   @Param("last_name") String last_name,
                   @Param("birth_date") Date birth_date,
                   @Param("height") Integer height,
                   @Param("weight") Integer weight,
                   @Param("gender") String gender,
                   @Param("pathologies") String pathologies,
                   @Param("patient_id") Long patient_id,
                   @Param("ward_id") Long ward_id);

}

