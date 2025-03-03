package com.markuu.demo.controllers;

import com.markuu.demo.configManager;
import com.markuu.demo.dto.Report2AdminData;
import com.markuu.demo.dto.Report2Data;
import com.markuu.demo.dto.ReportData;
import com.markuu.demo.dto.UserMainPageData;
import com.markuu.demo.models.*;
import com.markuu.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Tuple;
import java.math.BigInteger;
import java.sql.Time;
import java.text.ParseException;
import java.sql.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


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
        return "childPage";
    }

    @GetMapping("/getChildbirths")
    private String allChildbirth(Model model) {
        Iterable<Childbirth> childbirth = childbirthRepository.findAll();
        model.addAttribute("childbirths", childbirth);
        return "childbPage";
    }

    @GetMapping("/getEmployees")
    private String allEmployee(Model model) {
        Iterable<Employee> employee = employeeRepository.findAll();
        model.addAttribute("employees", employee);
        return "employeePage";
    }

    @GetMapping("/getHospitalizations")
    private String allHospitalization(Model model) {
        Iterable<Hospitalization> hospitalization = hospitalizationRepository.findAll();
        model.addAttribute("hospitalizations", hospitalization);
        return "hospPage";
    }

    @GetMapping("/getWards")
    private String allWard(Model model) {
        Iterable<Ward> ward = wardRepository.findAll();
        model.addAttribute("wards", ward);
        return "wardPage";
    }
    @GetMapping("/")
    private String page(Model model) {
        return "usersPage";
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





    configManager conMan = new configManager();
    Long hospId = conMan.getHospId();
    Long patientId = conMan.getPatientId();
    Long wardId = conMan.getWardId();
    Long childbId = conMan.getChildbId();
    Long childId = conMan.getChildId();
    Long employeeId = conMan.getEmployeeId();


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
        conMan.setHospId(hospId);
        conMan.saveConfig();
        return "hospPage";
    }


    @PostMapping("/addPatient")
    private String addPatient(
                              @RequestParam String first_name,
                              @RequestParam String middle_name,
                              @RequestParam String last_name,
                              @RequestParam String address,
                              @RequestParam String mobile_phone,
                              @RequestParam String birth_date,
                              @RequestParam String blood_type,
                              @RequestParam String medical_history,
                              @RequestParam Long ward_id
    ) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(birth_date);
        patientRepository.addPatient(patientId, first_name, middle_name, last_name, address, mobile_phone, sqlDate, blood_type, medical_history, ward_id);
        patientId++;
        conMan.setPatientId(patientId);
        conMan.saveConfig();
        return "mainPage";
    }

    @PostMapping("/addWard")
    private String addWard(
            @RequestParam Integer available_places,
            @RequestParam String wType,
            @RequestParam String equipment
    ) {
        wardRepository.addWard(wardId, available_places, wType, equipment);
        wardId++;
        conMan.setWardId(wardId);
        conMan.saveConfig();
        return "wardPage";
    }

    @PostMapping("/addChildb")
    private String addChildb(@RequestParam String childb_date,
                             @RequestParam String childb_start_time,
                             @RequestParam String childb_end_time,
                             @RequestParam String childb_type,
                             @RequestParam String childb_complications,
                             @RequestParam Long ward_id,
                             @RequestParam Long patient_id,
                             @RequestParam Long employee_id
    ) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(childb_date);
        LocalTime localStartTime = LocalTime.parse(childb_start_time + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
        java.sql.Time sqlStartTime = java.sql.Time.valueOf(localStartTime);
        LocalTime localEndTime = LocalTime.parse(childb_end_time + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
        java.sql.Time sqlEndTime = java.sql.Time.valueOf(localEndTime);
        childbirthRepository.addChildb(childbId, sqlDate, sqlStartTime, sqlEndTime, childb_type, childb_complications, ward_id, patient_id, employee_id);
        childbId++;
        conMan.setChildbId(childbId);
        conMan.saveConfig();
        return "mainPage";
    }

    @PostMapping("/addChild")
    private String addChild(@RequestParam String first_name,
                            @RequestParam String middle_name,
                            @RequestParam String last_name,
                            @RequestParam String birth_date,
                            @RequestParam Integer height,
                            @RequestParam Integer weight,
                            @RequestParam String gender,
                            @RequestParam String pathologies,
                            @RequestParam Long patient_id,
                            @RequestParam Long ward_id
    ) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(birth_date);
        childRepository.addChild(childId, first_name, middle_name, last_name, sqlDate, height, weight, gender, pathologies, patient_id, ward_id);
        childId++;
        conMan.setChildId(childId);
        conMan.saveConfig();
        return "childPage";
    }

    @PostMapping("/addEmployee")
    private String addEmployee(@RequestParam String first_name,
                               @RequestParam String middle_name,
                               @RequestParam String last_name,
                               @RequestParam String mobile_phone,
                               @RequestParam String post,
                               @RequestParam String experience,
                               @RequestParam Integer salary,
                               @RequestParam String work_shedule,
                               @RequestParam String skills
    ) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(experience);
        employeeRepository.addEmployee(employeeId, first_name, middle_name, last_name, mobile_phone, post, sqlDate, salary, work_shedule, skills);
        employeeId++;
        conMan.setEmployeeId(employeeId);
        conMan.saveConfig();
        return "childPage";
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


    @GetMapping("/toAdminPage")
    private String toAdminPage(Model model) {
        return "mainPage";
    }

    @GetMapping("/toUserMainPage")
    private String toUserMainPage(Model model) {
        List<Tuple > reportDataTuples = reportsRepository.userPageInfo();
        List<UserMainPageData> UserMainPageData = new ArrayList<>();

        for (Tuple tuple : reportDataTuples) {
            UserMainPageData data = new UserMainPageData();
            data.setChildbDate(tuple.get(0, Date.class));
            data.setChildbStartTime(tuple.get(1, Time.class));
            data.setChildbEndTime(tuple.get(2, Time.class));
            data.setChildbType(tuple.get(3, String.class));
            data.setPathologies(tuple.get(4, String.class));
            data.setWardId(tuple.get(5, BigInteger.class));
            data.setPatientFirstName(tuple.get(6, String.class));
            data.setPatientSecondName(tuple.get(7, String.class));
            data.setPatientLastName(tuple.get(8, String.class));
            data.setEmployeeFirstName(tuple.get(9, String.class));
            data.setEmployeeSecondName(tuple.get(10, String.class));
            data.setEmployeeLastName(tuple.get(11, String.class));
            data.setEmployeePost(tuple.get(12, String.class));
            UserMainPageData.add(data);
        }

        model.addAttribute("UserMainPageData", UserMainPageData);
        return "userMainPage";
    }

    @GetMapping("/toReport2")
    private String toReport2(Model model) {
        List<Tuple > reportDataTuples = reportsRepository.report2();
        List<Report2Data> report2Data = new ArrayList<>();

        for (Tuple tuple : reportDataTuples) {
            Report2Data data = new Report2Data();
            data.setWardId(tuple.get(0, BigInteger.class));
            data.setPatientName(tuple.get(1, String.class));
            data.setPatientId(tuple.get(2, BigInteger.class));
            data.setChildbType(tuple.get(3, String.class));
            data.setEmployeeName(tuple.get(4, String.class));
            data.setEmployeeId(tuple.get(5, BigInteger.class));
            data.setEmployeePost(tuple.get(6, String.class));
            report2Data.add(data);
        }

        model.addAttribute("report2Data", report2Data);
        return "report2";
    }

    @GetMapping("/toAdminReport2")
    private String toReport2Admin(Model model) {
        List<Tuple > reportDataTuples = reportsRepository.report2Admin();
        List<Report2AdminData> reportData = new ArrayList<>();

        for (Tuple tuple : reportDataTuples) {
            Report2AdminData data = new Report2AdminData();
            data.setFirstName(tuple.get(0, String.class));
            data.setPatientId(tuple.get(1, BigInteger.class));
            data.setChildbType(tuple.get(2, String.class));
            data.setPathologies(tuple.get(3, String.class));
            data.setExperience(tuple.get(4, Date.class));
            data.setSkills(tuple.get(5, String.class));
            reportData.add(data);
        }

        model.addAttribute("report2AdminData", reportData);
        return "report2Admin";
    }


    @PostMapping("/deletePatient")
    private String deletePatient(@RequestParam Long id,  Model model){
        patientRepository.deleteById(id);
        return "mainPage";
    }

    @PostMapping("/deleteChildb")
    private String deleteChildb(@RequestParam Long id,  Model model){
        childbirthRepository.deleteById(id);
        return "childbPage";
    }

    @PostMapping("/deleteChild")
    private String deleteChild(@RequestParam Long id,  Model model){
        childRepository.deleteById(id);
        return "childPage";
    }

    @PostMapping("/deleteEmployee")
    private String deleteEmployee(@RequestParam Long id,  Model model){
        employeeRepository.deleteById(id);
        return "employeePage";
    }

    @PostMapping("/deleteHosp")
    private String deleteHosp(@RequestParam Long id,  Model model){
        hospitalizationRepository.deleteById(id);
        return "hospPage";
    }

    @PostMapping("/deleteWard")
    private String deleteWard(@RequestParam Long id,  Model model){
        wardRepository.deleteById(id);
        return "wardPage";
    }
}
