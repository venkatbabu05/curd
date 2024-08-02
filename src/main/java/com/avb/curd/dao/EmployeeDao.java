package com.avb.curd.dao;

import com.avb.curd.entity.EmployeeDetails;
import com.avb.curd.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao {

    @Autowired
    private com.avb.curd.repo.EmployeeRepo employeeRepo;

    public boolean saveEmployeeData(EmployeeDetails employee) {
        boolean status = false;
        try {
            employeeRepo.save(employee);
            status = true;
        } catch (Exception exp) {
            status = false;
            System.out.println("Exception while save the emp data" + exp);
        }
        return status;
    }

    public Optional<EmployeeDetails> getEmployeeById(int empId) {
        Optional<EmployeeDetails> employeeDetails = null;
        try {
            employeeDetails = employeeRepo.findById(empId);
        } catch (Exception exp) {
            System.out.println("Exception while fetch the emp data" + empId);
        }
        return employeeDetails;
    }
}

