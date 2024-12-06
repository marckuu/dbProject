package com.markuu.demo.models;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Hospitalization {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHosp_data() {
        return Hosp_data;
    }

    public void setHosp_data(Date hosp_data) {
        Hosp_data = hosp_data;
    }

    public Time getHosp_time() {
        return Hosp_time;
    }

    public void setHosp_time(Time hosp_time) {
        Hosp_time = hosp_time;
    }

    public String getHosp_reason() {
        return Hosp_reason;
    }

    public void setHosp_reason(String hosp_reason) {
        Hosp_reason = hosp_reason;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date Hosp_data;

    private Time Hosp_time;

    @Column(length = 20, nullable = false)
    private String Hosp_reason;

    // Подключается столбец id из patients
    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
