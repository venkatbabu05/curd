package com.avb.curd.service;

import com.avb.curd.entity.EmployeeDetails;
import com.avb.curd.model.Employee;
import com.avb.curd.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private com.avb.curd.dao.EmployeeDao employeeDao;

    public boolean processEmployeeDate(EmployeeDetails employee) {
        return employeeDao.saveEmployeeData(employee);
    }

    public Optional<EmployeeDetails> getEmployeeById(int empId) {
        return employeeDao.getEmployeeById(empId);
    }
}
