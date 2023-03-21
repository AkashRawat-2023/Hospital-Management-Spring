package com.example.HospitalManagementSpring;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {

    HashMap<Integer,Patient> patientDB = new HashMap<>();

    @PostMapping("/addPatientViaParameter")
    public String addPatient(@RequestParam("patientId")Integer patientId,@RequestParam("name")String name,@RequestParam("age")Integer age,@RequestParam("disease")String disease){

        Patient patient = new Patient(patientId,name,age,disease);
        patientDB.put(patientId,patient);
        return "Patient added successfully via Parameter";
    }

    @PostMapping("/addPatientViaRequestBody")
    public String addPatient(@RequestBody Patient patient){

        int key = patient.getPatientId();
        patientDB.put(key,patient);

        return "Patient added successfully via RequesBody";
    }

    @GetMapping("/getPatientInfo")
    public Patient getPatient(@RequestParam("patientId") Integer patientId){

        Patient patient = patientDB.get(patientId);

        return patient;
    }

    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients(){
        List<Patient> patients = new ArrayList<>();

        for(Patient p : patientDB.values()){
            patients.add(p);
        }

        return patients;
    }

    @GetMapping("/getPatientByName")
    public Patient getPatientByName(@RequestParam("name")String name){

        for(Patient p : patientDB.values()){
            if(p.getName() == name){
                return p;
            }
        }
        return null;
    }
    @GetMapping("/getInfoViaPathVariable/{patientId}/{disease}")
    public List<Patient> getPatientInfo(@PathVariable("age")Integer age,@PathVariable("disease")String disease){
        List<Patient> patients = new ArrayList<>();

        for(Patient p : patientDB.values()){
             if(p.getAge()>age && p.getDisease().equals(disease)){
            patients.add(p);
            }
        }
        return patients;
    }
    @GetMapping("/getPatientsListGreaterThanAge")
    public List<Patient> getPatientsGreaterThanAge(@RequestParam("age")Integer age) {

        List<Patient> patients = new ArrayList<>();

        for (Patient p : patientDB.values()) {

            if (p.getAge() > age) {
                patients.add(p);
            }
        }
        return patients;
    }

    @PutMapping("/updatePatientDetail")
    public String updatePatientDetails(@RequestBody Patient patient){
        int key = patient.getPatientId();

        if(patientDB.containsKey(key)){
            patientDB.put(key,patient);
            return "Updated";
        }else{
            return "Data not exist";
        }
    }
    @PutMapping("/updateDisease")
    public String updateDisease(@RequestParam("patientId") int patientId,@RequestParam("disease")String disease){
        Patient p = patientDB.get(patientId);

        int key = p.getPatientId();
        if(patientDB.containsKey(key)){
            p.setDisease(disease);
            patientDB.put(key,p);
            return "Updated";
        }else{
            return "Data not exist";
        }
    }

}
