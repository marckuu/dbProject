package com.markuu.demo.repo;

import com.markuu.demo.models.Patient;
import com.markuu.demo.models.ReportData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReportsRepository extends CrudRepository<Patient, Long> {

    @Query(value = "SELECT " +
            "p.first_name AS \"Имя\", " +
            "p.middle_name AS \"Фамилия\", " +
            "p.last_name AS \"Отчество\", " +
            "h.hosp_data AS \"Дата поступления\", " +
            "p.birth_date AS \"Дата рождения\", " +
            "c.pathologies AS \"Наличие патологий у плода\", " +
            "b.childb_type AS \"Вид родов\" " +
            "FROM " +
            "patient p " +
            "JOIN " +
            "hospitalization h ON p.id = h.patient_id " +
            "JOIN " +
            "childbirth b ON p.id = b.patient_id " +
            "JOIN " +
            "child c ON p.id = c.patient_id " +
            "WHERE " +
            "b.childb_date IS NOT NULL;", nativeQuery = true)
    List<Tuple> report1();


}

