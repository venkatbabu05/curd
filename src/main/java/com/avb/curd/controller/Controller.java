package com.avb.curd.controller;

import com.avb.curd.entity.EmployeeDetails;
import com.avb.curd.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/createEmployee")
    public ResponseEntity<String> createEmployeeData(@RequestBody EmployeeDetails employee) {
        boolean status = service.processEmployeeDate(employee);
        return new ResponseEntity<>(status ? "Data saved successfully" : "Unable to save the data", HttpStatus.OK);
    }

    @GetMapping("/getEmployee/{empId}")
    public ResponseEntity<EmployeeDetails> getEmployee(@PathVariable int empId) {
        System.out.println("test");
        EmployeeDetails employeeDetails = null;
        Optional<EmployeeDetails> emp = service.getEmployeeById(empId);
        if (emp.isPresent()) {
            employeeDetails = emp.get();
        }
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
    }
}
