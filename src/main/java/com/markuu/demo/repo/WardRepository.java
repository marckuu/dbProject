package com.markuu.demo.repo;

import com.markuu.demo.models.Ward;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends CrudRepository<Ward, Long> {

    @Query("SELECT u FROM Ward u")
    List<Ward> findAll();



}
