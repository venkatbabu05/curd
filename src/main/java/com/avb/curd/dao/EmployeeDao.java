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
        Employees empData = null;
        try {
            empData = employeeRepo.save(employee);
        } catch (Exception exp) {
            System.out.println("Exception while save the emp data" + exp);
        }
        return empData;
    }

    public Optional<Employees> getEmployeeById(int empId) {
        Optional<Employees> emp = null;
        try {
            emp = employeeRepo.findById(empId);
        } catch (Exception exp) {
            System.out.println("Exception while fetch the emp data" + empId);
        }
        return emp;
    }
}

