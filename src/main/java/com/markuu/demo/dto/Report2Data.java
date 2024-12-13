package com.markuu.demo.dto;

import java.math.BigInteger;
import java.sql.Date;

public class Report2Data {
    private BigInteger wardId;
    private String patientName;
    private BigInteger patientId;
    private String childbType;
    private String employeeName;
    private BigInteger employeeId;
    private String employeePost;

    public BigInteger getWardId() {
        return wardId;
    }

    public void setWardId(BigInteger wardId) {
        this.wardId = wardId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public BigInteger getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(BigInteger employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeePost() {
        return employeePost;
    }

    public void setEmployeePost(String employeePost) {
        this.employeePost = employeePost;
    }
// getters and setters
}