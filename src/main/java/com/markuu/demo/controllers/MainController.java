package com.markuu.demo.controllers;

import com.markuu.demo.models.*;
import com.markuu.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;


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
        return "childPage";
    }

    @GetMapping("/employeePage")
    private String employeePage(Model model) {
        Iterable<Employee> employee = employeeRepository.findAll();
        model.addAttribute("employees", employee);
        return "employeePage";
    }






    @PostMapping("/modifyPatient")
    private String modifyPatient(@RequestParam String firstName, @RequestParam String middleName, @RequestParam String lastName, @RequestParam String bloodType,
                                 @RequestParam String mobilePhone, @RequestParam String address, @RequestParam String medicalHistory, @RequestParam Long ward, Model model, @RequestParam String birthDate, @RequestParam Long id) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        patientRepository.set(firstName, middleName, lastName, address, mobilePhone, birthDate, bloodType, medicalHistory, ward, id);
        return "mainPage";
    }

}
