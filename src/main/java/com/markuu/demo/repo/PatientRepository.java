package com.markuu.demo.repo;

import com.markuu.demo.models.Patient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Query("SELECT u FROM Patient u")
    List<Patient> findAll();
//

//    @Modifying
//    @Query("INSERT INTO Patient (first_name, middle_name, last_name, address, mobile_phone, birth_date, blood_type, medical_history, ward) VALUES (:first_name, :middle_name, :last_name, :address, :mobile_phone, :birth_date, :blood_type, :medical_history, :ward)")
//    void modify (@Param("first_name") String first_name, @Param("middle_name") String middle_name, @Param("last_name") String last_name, @Param("address") String address,
//    @Param("mobile_phone") String mobile_phone, @Param("birth_date") String birth_date, @Param("blood_type") String blood_type, @Param("medical_history") String medical_history,
//                 @Param("ward") String ward);
//

    @Modifying
    @Transactional
    @Query("UPDATE Patient SET first_name = :first_name, middle_name = :middle_name, last_name = :last_name, address = :address, mobile_phone = :mobile_phone, birth_date = :birth_date, blood_type = :blood_type, medical_history = :medical_history, ward.id = :ward WHERE id = :id")
    void set(@Param("first_name") String first_name, @Param("middle_name") String middle_name, @Param("last_name") String last_name, @Param("address") String address,
             @Param("mobile_phone") String mobile_phone, @Param("birth_date") Date birth_date, @Param("blood_type") String blood_type, @Param("medical_history") String medical_history,
             @Param("ward") Long ward, @Param("id") Long id);


}


