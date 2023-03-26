package com.example.HospitalManagementSpring.controller;

import com.example.HospitalManagementSpring.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clinic")
public class ClinicController {

    @Autowired
    NurseService nurseService;

    @GetMapping("/checkObject")
    public String checkObject(){
        System.out.println("The nurse object in Clinic Controller "+nurseService);
        return null;
    }
}
