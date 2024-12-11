package com.markuu.demo.controllers;

import com.markuu.demo.models.*;
import com.markuu.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Tuple;
import java.security.SecureRandom;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    @Autowired
    private ReportsRepository reportsRepository;


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
        if (childbirthStartTime.length() == 5) { // hh:mm
            childbirthStartTime += ":00"; // добавляем секунды
        }
        if (childbirthEndTime.length() == 5) { // hh:mm
            childbirthEndTime += ":00"; // добавляем секунды
        }
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
        if (hospTime.length() == 5) { // hh:mm
            hospTime += ":00"; // добавляем секунды
        }
        java.sql.Time sqlTime = java.sql.Time.valueOf(hospTime);
        hospitalizationRepository.set(sqlDate, sqlTime, hospReason, patientId, id);
        return "hospPage";
    }






Long hospId = 2L;



    @PostMapping("/addHosp")
    private String addHosp(@RequestParam String hData,
                           @RequestParam String hTime,
                           @RequestParam String hReason,
                           @RequestParam Long pId
                           ) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(hData);
        LocalTime localTime = LocalTime.parse(hTime + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
        java.sql.Time sqlTime = java.sql.Time.valueOf(localTime);
        hospitalizationRepository.addHospitalization(sqlDate, sqlTime, hReason, pId, hospId);
        hospId++;
        return "hospPage";
    }




    @GetMapping("/toReport1")
    private String toReport1(Model model) {
        List<Tuple > reportDataTuples = reportsRepository.report1();
        List<ReportData> reportData = new ArrayList<>();

        for (Tuple tuple : reportDataTuples) {
            ReportData data = new ReportData();
            data.setFirstName(tuple.get(0, String.class));
            data.setSecondName(tuple.get(1, String.class));
            data.setLastName(tuple.get(2, String.class));
            data.setHosp_data(tuple.get(3, Date.class));
            data.setBirth_date(tuple.get(4, Date.class));
            data.setPathologies(tuple.get(5, String.class));
            data.setChildbType(tuple.get(6, String.class));
            reportData.add(data);
        }

        model.addAttribute("reportData", reportData);
        return "report1";
    }

}
