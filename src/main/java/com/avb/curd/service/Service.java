package com.avb.curd.service;

import com.avb.curd.entity.Employees;
import com.avb.curd.model.Employee;
import com.avb.curd.transform.TransformRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    TransformRequest transformRequest;

    @Autowired
    private com.avb.curd.dao.EmployeeDao employeeDao;

    public Employees processEmployeeDate(Employee emp) {
        Employees entity = transformRequest.parseEmployee(emp);
        return employeeDao.saveEmployeeData(entity);
    }

    public Optional<Employees> getEmployeeById(int empId) {
        return  employeeDao.getEmployeeById(empId);
    }
}
