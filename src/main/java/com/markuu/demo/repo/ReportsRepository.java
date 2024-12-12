package com.markuu.demo.repo;

import com.markuu.demo.models.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

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

    @Query(value = "SELECT \n" +
            "    c.childb_date AS \"Дата родов\",\n" +
            "    c.childb_start_time AS \"Время начала родов\",\n" +
            "    c.childb_end_time AS \"Время окончания родов\",\n" +
            "    c.childb_type AS \"Вид родов\",\n" +
            "    c.childb_complications AS \"Осложнения при родах\",\n" +
            "    w.id AS \"Номер палаты\",\n" +
            "    p.first_name AS \"Имя пациента\",\n" +
            "    p.middle_name AS \"Фамилия пациента\",\n" +
            "    p.last_name AS \"Отчество пациента\",\n" +
            "    e.first_name AS \"Имя сотрудника\",\n" +
            "    e.middle_name AS \"Фамилия сотрудника\",\n" +
            "    e.last_name AS \"Отчество сотрудника\",\n" +
            "    e.post AS \"Должность сотрудника\"\n" +
            "FROM \n" +
            "    childbirth c\n" +
            "JOIN \n" +
            "    ward w ON c.ward_id = w.id\n" +
            "JOIN \n" +
            "    patient p ON c.patient_id = p.id\n" +
            "JOIN \n" +
            "    employee e ON c.employee_id = e.id;", nativeQuery = true)
    List<Tuple> userPageInfo();


    @Query(value = "SELECT \n" +
            "    r.id AS \"Номер палаты\",\n" +
            "    p.first_name AS \"Имя пациента\",\n" +
            "    p.id AS \"Номер пациенки\", \n" +
            "    c.childb_type AS \"Вид родов\",\n" +
            "    e.first_name AS \"Имя сотрудника\",\n" +
            "    e.id AS \"Номер сотрудника\",\n" +
            "    e.post AS \"Должность сотрудника\"\n" +
            "FROM \n" +
            "    ward r\n" +
            "JOIN \n" +
            "    patient p ON r.id = p.ward_id\n" +
            "JOIN \n" +
            "    childbirth c ON p.id = c.patient_id\n" +
            "JOIN \n" +
            "    employee e ON c.employee_id = e.id\n" +
            "ORDER BY e.middle_name", nativeQuery = true)
    List<Tuple> report2();

    @Query(value = "SELECT \n" +
            "    p.first_name AS \"Имя роженицы\",\n" +
            "\tp.id AS \"Номер роженицы\",\n" +
            "\tb.childb_type AS \"Вид родов\",\n" +
            "\tc.pathologies AS \"Осложнения\",\n" +
            "    d.experience AS \"Стаж\",\n" +
            "    d.skills AS \"Специальные навыки\"\n" +
            "FROM \n" +
            "    patient p\n" +
            "JOIN \n" +
            "\tchildbirth b ON b.patient_id = p.id\n" +
            "JOIN \n" +
            "\tchild c ON c.patient_id = p.id\n" +
            "JOIN \n" +
            "    employee d ON b.employee_id = p.id;", nativeQuery = true)
    List<Tuple> report2Admin();

}

