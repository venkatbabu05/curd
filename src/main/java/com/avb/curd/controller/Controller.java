package com.avb.curd.controller;

import com.avb.curd.entity.Employees;
import com.avb.curd.model.Employee;
import com.avb.curd.model.Response;
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
    public ResponseEntity<Response> createEmployeeData(@RequestBody Employee employee) {
        Employees emp = service.processEmployeeDate(employee);
        return getResponse(emp, "data saved successfully");
    }

    @GetMapping("/getEmployee/{empId}")
    public ResponseEntity<Response> getEmployee(@PathVariable int empId) {
        String message = "No data Found";
        Employees empDate = null;
        Optional<Employees> emp = service.getEmployeeById(empId);
        if (emp.isPresent()) {
            empDate = emp.get();
            message = "Employee data found";
        }
        return getResponse(empDate, message);
    }

    private ResponseEntity<Response> getResponse(Employees empDate, String message) {
        Response response = new Response();
        response.setMessage(message);
        response.setData(empDate);
        response.setStatus(String.valueOf(HttpStatus.OK));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
