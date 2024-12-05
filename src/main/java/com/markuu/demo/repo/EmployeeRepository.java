package com.markuu.demo.repo;

import com.markuu.demo.models.Employee;
import com.markuu.demo.models.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("SELECT u FROM Employee u")
    List<Employee> findAll();



}
