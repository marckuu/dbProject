package com.markuu.demo.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Employee {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getExperience() {
        return experience;
    }

    public void setFirst_job_day(Date experience) {
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWork_schedule() {
        return work_schedule;
    }

    public void setWork_schedule(String work_schedule) {
        this.work_schedule = work_schedule;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public List<Childbirth> getChildbirths() {
        return childbirths;
    }

    public void setChildbirths(List<Childbirth> childbirths) {
        this.childbirths = childbirths;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String first_name, middle_name, last_name;

    @Column(length = 12)
    private String mobile_phone;

    private String post;

    private Date experience;

    private int salary;

    @Column(nullable = false)
    private String work_schedule;

    private String skills;

    // Список родов и метка для использования id в childbirth
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Childbirth> childbirths;
}
