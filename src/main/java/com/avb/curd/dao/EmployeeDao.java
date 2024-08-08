package com.avb.curd.dao;

import com.avb.curd.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmployeeDao {

    @Autowired
    private com.avb.curd.repo.EmployeeRepo employeeRepo;

    public Employees saveEmployeeData(Employees employee) {
        return employeeRepo.save(employee);
    }

    public Optional<Employees> getEmployeeById(int empId) {
        return employeeRepo.findById(empId);
    }
}

