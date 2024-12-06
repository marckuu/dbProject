package com.markuu.demo.controllers;

import com.markuu.demo.models.*;
import com.markuu.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.SecureRandom;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;


@Controller
public class MainController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private ChildbirthRepository childbirthRepository;

    @Autowired
    private WardRepository wardRepository;

    @Autowired
    private HospitalizationRepository hospitalizationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("/getPatients")
    private String allPatient(Model model) {
        Iterable<Patient> patient = patientRepository.findAll();
        model.addAttribute("patients", patient);
        return "mainPage";
    }

    @GetMapping("/getChildrens")
    private String allChild(Model model) {
        Iterable<Child> child = childRepository.findAll();
        model.addAttribute("childs", child);
        return "testmain";
    }

    @GetMapping("/getChildbirths")
    private String allChildbirth(Model model) {
        Iterable<Childbirth> childbirth = childbirthRepository.findAll();
        model.addAttribute("childbirths", childbirth);
        return "testmain";
    }

    @GetMapping("/getEmployees")
    private String allEmployee(Model model) {
        Iterable<Employee> employee = employeeRepository.findAll();
        model.addAttribute("employees", employee);
        return "testmain";
    }

    @GetMapping("/getHospitalizations")
    private String allHospitalization(Model model) {
        Iterable<Hospitalization> hospitalization = hospitalizationRepository.findAll();
        model.addAttribute("hospitalizations", hospitalization);
        return "testmain";
    }

    @GetMapping("/getWards")
    private String allWard(Model model) {
        Iterable<Ward> ward = wardRepository.findAll();
        model.addAttribute("wards", ward);
        return "testmain";
    }
    @GetMapping("/")
    private String page(Model model) {
        return "mainPage";
    }

    @GetMapping("/mainPage")
    private String mainPage(Model model) {
        Iterable<Patient> patient = patientRepository.findAll();
        model.addAttribute("patients", patient);
        return "mainPage";
    }

    @GetMapping("/childPage")
    private String childPage(Model model) {
        Iterable<Child> child = childRepository.findAll();
        model.addAttribute("childs", child);
        return "childPage";
    }

    @GetMapping("/wardPage")
    private String wardPage(Model model) {
        Iterable<Ward> ward = wardRepository.findAll();
        model.addAttribute("wards", ward);
        return "wardPage";
    }

    @GetMapping("/hospPage")
    private String hospPage(Model model) {
        Iterable<Hospitalization> hospitalization = hospitalizationRepository.findAll();
        model.addAttribute("hospitalizations", hospitalization);
        return "hospPage";
    }

    @GetMapping("/childbPage")
    private String childbPage(Model model) {
        Iterable<Childbirth> childbirth = childbirthRepository.findAll();
        model.addAttribute("childbirths", childbirth);
        return "childbPage";
    }

    @GetMapping("/employeePage")
    private String employeePage(Model model) {
        Iterable<Employee> employee = employeeRepository.findAll();
        model.addAttribute("employees", employee);
        return "employeePage";
    }






    @PostMapping("/modifyPatient")
    private String modifyPatient(@RequestParam String firstName,
                                 @RequestParam String middleName,
                                 @RequestParam String lastName,
                                 @RequestParam String bloodType,
                                 @RequestParam String mobilePhone,
                                 @RequestParam String address,
                                 @RequestParam String medicalHistory,
                                 @RequestParam Long ward,
                                 Model model,
                                 @RequestParam String birthDate,
                                 @RequestParam Long id) throws ParseException {
        java.sql.Date sqlDate = java.sql.Date.valueOf(birthDate);
        patientRepository.set(firstName, middleName, lastName, address, mobilePhone, sqlDate, bloodType, medicalHistory, ward, id);
        return "mainPage";
    }

    @PostMapping("/modifyWard")
    private String modifyWard(@RequestParam String type,
                                 @RequestParam int availablePlaces,
                                 @RequestParam String equipment,
                                 @RequestParam Long id) throws ParseException {
        wardRepository.set(availablePlaces, type, equipment, id);
        return "wardPage";
    }


    @PostMapping("/modifyChild")
    private String modifyChild(@RequestParam String firstName,
                               @RequestParam String middleName,
                               @RequestParam String lastName,
                               @RequestParam int height,
                               @RequestParam int weight,
                               @RequestParam String gender,
                               @RequestParam String pathologies,
                               @RequestParam Long ward,
                               Model model,
                               @RequestParam String birthDate,
                               @RequestParam Long mother,
                               @RequestParam Long id) throws ParseException {
        java.sql.Date sqlDate = java.sql.Date.valueOf(birthDate);
        childRepository.set(firstName, middleName, lastName, height, weight, gender, pathologies, ward, sqlDate, mother, id);
        return "childPage";
    }

    @PostMapping("/modifyChildb")
    private String modifyChildb(@RequestParam String birthDate,
                                @RequestParam String childbirthStartTime,
                                @RequestParam String childbirthEndTime,
                                @RequestParam String childbirthType,
                                @RequestParam String complications,
                                @RequestParam Long ward,
                                @RequestParam Long employee,
                                @RequestParam Long patient,
                                Model model,
                                @RequestParam Long id) throws ParseException {
        java.sql.Date sqlDate = java.sql.Date.valueOf(birthDate);
        java.sql.Time sqlStartTime = java.sql.Time.valueOf(childbirthStartTime);
        java.sql.Time sqlEndTime = java.sql.Time.valueOf(childbirthEndTime);
        childbirthRepository.set(sqlDate, sqlStartTime, sqlEndTime, childbirthType, complications, ward,
                employee, patient, id);
        return "childbPage";
    }

    @PostMapping("/modifyEmployee")
    private String modifyEmployee(@RequestParam String firstName,
                                @RequestParam String middleName,
                                @RequestParam String lastName,
                                @RequestParam String mobilePhone,
                                @RequestParam String post,
                                @RequestParam int salary,
                                @RequestParam String staffExperience,
                                @RequestParam String staffSchedule,
                                @RequestParam String staffSkills,
                                Model model,
                                @RequestParam Long id) throws ParseException {
        java.sql.Date sqlDate = java.sql.Date.valueOf(staffExperience);
        employeeRepository.set(firstName, middleName, lastName, mobilePhone, post, salary,
                sqlDate, staffSchedule, staffSkills, id);
        return "employeePage";
    }


    @PostMapping("/modifyHosp")
    private String modifyHosp(@RequestParam Long patientId,
                                  @RequestParam String hospData,
                                  @RequestParam String hospTime,
                                  @RequestParam String hospReason,
                                  Model model,
                                  @RequestParam Long id) throws ParseException {
        java.sql.Date sqlDate = java.sql.Date.valueOf(hospData);
        java.sql.Time sqlTime = java.sql.Time.valueOf(hospTime);
        hospitalizationRepository.set(sqlDate, sqlTime, hospReason, patientId, id);
        return "employeePage";
    }
}
