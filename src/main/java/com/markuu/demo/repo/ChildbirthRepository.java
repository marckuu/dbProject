package com.markuu.demo.repo;

import com.markuu.demo.models.Childbirth;
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
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ChildbirthRepository extends CrudRepository<Childbirth, Long> {

    @Query("SELECT u FROM Childbirth u")
    List<Childbirth> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Childbirth SET childB_date = :childB_date, childB_start_time = :childB_start_time, childB_end_time = :childB_end_time, " +
            "childB_type = :childB_type, childB_complications = :childB_complications, ward.id = :childBWard, employee.id = :childBEmployee," +
            " patient.id = :patient WHERE id = :id")
    void set(@RequestParam Date childB_date,
             @RequestParam Time childB_start_time,
             @RequestParam Time childB_end_time,
             @RequestParam String childB_type,
             @RequestParam String childB_complications,
             @RequestParam Long childBWard,
             @RequestParam Long childBEmployee,
             @RequestParam Long patient,
             @RequestParam Long id);

}
