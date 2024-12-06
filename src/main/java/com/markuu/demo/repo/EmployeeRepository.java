package com.markuu.demo.repo;

import com.markuu.demo.models.Employee;
import com.markuu.demo.models.Patient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("SELECT u FROM Employee u")
    List<Employee> findAll();


    @Modifying
    @Transactional
    @Query("UPDATE Employee SET first_name = :first_name, middle_name = :middle_name, last_name = :last_name, mobile_phone = :mobile_phone, " +
            "post = :post, salary = :salary, experience = :experience, work_schedule = :work_schedule, skills = :skills WHERE id = :id")
    void set(@RequestParam String first_name,
             @RequestParam String middle_name,
             @RequestParam String last_name,
             @RequestParam String mobile_phone,
             @RequestParam String post,
             @RequestParam int salary,
             @RequestParam Date experience,
             @RequestParam String work_schedule,
             @RequestParam String skills,
             @RequestParam Long id);
}
