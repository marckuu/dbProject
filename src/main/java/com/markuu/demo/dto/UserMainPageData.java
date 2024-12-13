package com.markuu.demo.dto;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;

public class UserMainPageData {
    private Date childbDate;
    private Time childbStartTime;
    private Time childbEndTime;
    private String childbType;
    private String pathologies;
    private BigInteger wardId;
    private String patientFirstName;
    private String patientSecondName;
    private String patientLastName;
    private String employeeFirstName;
    private String employeeSecondName;
    private String employeeLastName;
    private String employeePost;
   // getters and setters

    public Date getChildbDate() {
        return childbDate;
    }

    public void setChildbDate(Date childbDate) {
        this.childbDate = childbDate;
    }

    public Time getChildbStartTime() {
        return childbStartTime;
    }

    public void setChildbStartTime(Time childbStartTime) {
        this.childbStartTime = childbStartTime;
    }

    public Time getChildbEndTime() {
        return childbEndTime;
    }

    public void setChildbEndTime(Time childbEndTime) {
        this.childbEndTime = childbEndTime;
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

    public BigInteger getWardId() {
        return wardId;
    }

    public void setWardId(BigInteger wardId) {
        this.wardId = wardId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientSecondName() {
        return patientSecondName;
    }

    public void setPatientSecondName(String patientSecondName) {
        this.patientSecondName = patientSecondName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeSecondName() {
        return employeeSecondName;
    }

    public void setEmployeeSecondName(String employeeSecondName) {
        this.employeeSecondName = employeeSecondName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeePost() {
        return employeePost;
    }

    public void setEmployeePost(String employeePost) {
        this.employeePost = employeePost;
    }
}