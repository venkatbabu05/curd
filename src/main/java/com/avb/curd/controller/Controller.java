package com.avb.curd.controller;

import com.avb.curd.entity.Employees;
import com.avb.curd.entity.User;
import com.avb.curd.model.Employee;
import com.avb.curd.model.Response;
import com.avb.curd.service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class Controller {
    private Service service;
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping("/createEmployee")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Response> createEmployeeData(@RequestBody Employee employee) {
        Employees emp = service.processEmployeeDate(employee);
        return getResponse(emp, "data saved successfully");
    }

    @GetMapping("/getEmployee/{empId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
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

    @PutMapping("/updateEmployee/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Response> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
        Employees empData = service.updateEmployee(id, emp);
        return getResponse(empData, empData != null ? "Data saved successfully" : "Employee data Not found for given id :" + id);
    }

    @PatchMapping("/updateEmployeeByField/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Response> updateEmployeeByField(@PathVariable int id, @RequestBody Map<String, Object> emp) {
        Employees empData = service.updateEmployeeByField(id, emp);
        return getResponse(empData, empData != null ? "Data saved successfully" : "Employee data Not found for given id :" + id);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        String result = service.deleteEmployee(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/newUser")
    public ResponseEntity<String> addNewUser(@RequestBody User userInfo) {
        String result = service.addUser(userInfo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private ResponseEntity<Response> getResponse(Employees empDate, String message) {
        Response response = new Response();
        response.setMessage(message);
        response.setData(empDate);
        response.setStatus(String.valueOf(HttpStatus.OK));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
