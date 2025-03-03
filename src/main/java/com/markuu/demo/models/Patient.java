package com.markuu.demo.models;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Patient {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getMedical_history() {
        return medical_history;
    }

    public void setMedical_history(String medical_history) {
        this.medical_history = medical_history;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public Hospitalization getHospitalization() {
        return (Hospitalization) hospitalization;
    }

    public void setHospitalization(Hospitalization hospitalization) {
        this.hospitalization = (List<Hospitalization>) hospitalization;
    }

    public List<Childbirth> getChildbirths() {
        return childbirths;
    }

    public void setChildbirths(List<Childbirth> childbirths) {
        this.childbirths = childbirths;
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

    @Column(length = 50, nullable = false)
    private String first_name, middle_name, last_name;

    @Column(length = 200)
    private String address;

    @Column(length = 12)
    private String mobile_phone;

    private Date birth_date;

    @Column(length = 2, nullable = false)
    private String blood_type;

    private String medical_history;

    // Подключается столбец id из ward
    @ManyToOne
    @JoinColumn(name = "ward_id", nullable = false)
    private Ward ward;

    // Создается метка для использования id как внешнего ключа в Hospitalization
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Hospitalization> hospitalization;

    // Создается список родов и метка для получения ключа в childbirth
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Childbirth> childbirths;

    // Создается список детей и метка для получения ключа в child
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Child> child;
}

