package com.markuu.demo.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Childbirth {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getChildB_date() {
        return childB_date;
    }

    public void setChildB_date(Date childB_date) {
        this.childB_date = childB_date;
    }

    public Time getChildB_start_time() {
        return childB_start_time;
    }

    public void setChildB_start_time(Time childB_start_time) {
        this.childB_start_time = childB_start_time;
    }

    public Time getChildB_end_time() {
        return childB_end_time;
    }

    public void setChildB_end_time(Time childB_end_time) {
        this.childB_end_time = childB_end_time;
    }

    public String getChildB_type() {
        return childB_type;
    }

    public void setChildB_type(String childB_type) {
        this.childB_type = childB_type;
    }

    public String getChildB_complications() {
        return childB_complications;
    }

    public void setChildB_complications(String childB_complications) {
        this.childB_complications = childB_complications;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date childB_date;

    private Time childB_start_time;

    private Time childB_end_time;

    @Column(length = 50, nullable = false)
    private String childB_type;

    @Column(length = 200)
    private String childB_complications;

    // Подключается столбец id из ward
    @ManyToOne
    @JoinColumn(name = "ward_id", nullable = false)
    private Ward ward;

    // Подключается столбец id из patient
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    // Подключается столбец id из Employee
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

}
