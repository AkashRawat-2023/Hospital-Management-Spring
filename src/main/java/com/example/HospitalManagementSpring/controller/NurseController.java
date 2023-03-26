package com.example.HospitalManagementSpring.controller;


import com.example.HospitalManagementSpring.models.Nurse;
import com.example.HospitalManagementSpring.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")

public class NurseController {

    @Autowired
    NurseService nurseService;

    //checking reusability of object
    @GetMapping("/checkObject")
    public String checkObject(){
        System.out.println("The nurse object in Clinic Controller "+nurseService);
        return null;
    }
    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse){

        String ans = nurseService.addNurse(nurse);

        return ans;
    }
    @GetMapping("/getByAge")
    public List<Nurse> getNursesGreaterThanAge(@RequestParam("age")Integer age){

        List<Nurse> nurseList = nurseService.getList(age);
        return nurseList;
    }

    @GetMapping("/getByQualification")
    public List<Nurse> getNursesByQualification(@RequestParam("qualification")String qualification){

        List<Nurse> nurses =nurseService.getNursesWithQualificaiton(qualification);
        return nurses;
    }

}
