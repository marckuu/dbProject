package com.markuu.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ward {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAvailable_places() {
        return available_places;
    }

    public void setAvailable_places(int available_places) {
        this.available_places = available_places;
    }

    public String getType() {
        return wType;
    }

    public void setType(String type) {
        this.wType = type;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Patient> getChildbirth() {
        return Childbirth;
    }

    public void setChildbirth(List<Patient> childbirth) {
        Childbirth = childbirth;
    }

    public List<Child> getChild() {
        return child;
    }

    public void setChild(List<Child> child) {
        this.child = child;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int available_places;

    @Column(nullable = false)
    private String wType;

    private String equipment;

    // Создается список находящихся пациентов и создается метка как ward для доступа в patients
    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL)
    private List<Patient> patients;

    // Создается список родов и создается метка как ward для доступа в Childbirth
    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL)
    private List<Patient> Childbirth;

    // Создается список детей и создается метка как ward для доступа в child
    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL)
    private List<Child> child;



}