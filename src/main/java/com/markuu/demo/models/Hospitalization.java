package com.markuu.demo.models;

import javax.persistence.*;

@Entity
public class Hospitalization {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHosp_data() {
        return Hosp_data;
    }

    public void setHosp_data(String hosp_data) {
        Hosp_data = hosp_data;
    }

    public String getHosp_time() {
        return Hosp_time;
    }

    public void setHosp_time(String hosp_time) {
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

    @Column(columnDefinition = "DATE", nullable = false)
    private String Hosp_data;

    @Column(columnDefinition = "TIME", nullable = false)
    private String Hosp_time;

    @Column(length = 20, nullable = false)
    private String Hosp_reason;

    // Подключается столбец id из patients
    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
