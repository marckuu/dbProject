package com.markuu.demo.repo;

import com.markuu.demo.models.Ward;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
public interface WardRepository extends CrudRepository<Ward, Long> {

    @Query("SELECT u FROM Ward u")
    List<Ward> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Ward SET available_places = :available_places, wType = :wType, equipment = :equipment WHERE id = :id")
    void set(@Param("available_places") int available_places,
             @Param("wType") String wType,
             @Param("equipment") String equipment,
             @Param("id") Long id
             );
}

