package com.markuu.demo.repo;

import com.markuu.demo.models.Child;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends CrudRepository<Child, Long> {

    @Query("SELECT u FROM Child u")
    List<Child> findAll();


}

