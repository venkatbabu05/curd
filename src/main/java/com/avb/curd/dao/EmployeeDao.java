package com.avb.curd.dao;

import com.avb.curd.entity.Employees;
import com.avb.curd.entity.User;
import com.avb.curd.repo.EmployeeRepo;
import com.avb.curd.repo.UserRepo;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class EmployeeDao {
    private com.avb.curd.repo.EmployeeRepo employeeRepo;
    private com.avb.curd.repo.UserRepo userRepo;
    public EmployeeDao(EmployeeRepo employeeRepo, UserRepo userRepo) {
        this.employeeRepo = employeeRepo;
        this.userRepo = userRepo;
    }

    public Employees saveEmployeeData(Employees employee) {
        return employeeRepo.save(employee);
    }

    public Optional<Employees> getEmployeeById(int empId) {
        return employeeRepo.findById(empId);
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public void deleteEmployee(int empId){
        employeeRepo.deleteById(empId);
    }
}

