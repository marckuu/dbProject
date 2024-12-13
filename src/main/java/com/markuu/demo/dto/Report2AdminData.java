package com.markuu.demo.dto;

import java.math.BigInteger;
import java.sql.Date;

public class Report2AdminData {
    private String firstName;
    private BigInteger patientId;
    private String childbType;
    private String pathologies;
    private Date experience;
    private String skills;
    // getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public BigInteger getPatientId() {
        return patientId;
    }

    public void setPatientId(BigInteger patientId) {
        this.patientId = patientId;
    }

    public String getChildbType() {
        return childbType;
    }

    public void setChildbType(String childbType) {
        this.childbType = childbType;
    }

    public String getPathologies() {
        return pathologies;
    }

    public void setPathologies(String pathologies) {
        this.pathologies = pathologies;
    }

    public Date getExperience() {
        return experience;
    }

    public void setExperience(Date experience) {
        this.experience = experience;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }


}