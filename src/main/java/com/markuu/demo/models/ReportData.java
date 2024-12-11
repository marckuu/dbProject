package com.markuu.demo.models;

import java.sql.Date;

public class ReportData {
    private String firstName;
    private String secondName;
    private String lastName;
    private Date hosp_data;
    private Date birth_date;
    private String pathologies;
    private String childbType;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getHosp_data() {
        return hosp_data;
    }

    public void setHosp_data(Date hosp_data) {
        this.hosp_data = hosp_data;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getPathologies() {
        return pathologies;
    }

    public void setPathologies(String pathologies) {
        this.pathologies = pathologies;
    }

    public String getChildbType() {
        return childbType;
    }

    public void setChildbType(String childbType) {
        this.childbType = childbType;
    }
    // getters and setters
}