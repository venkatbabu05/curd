package com.avb.curd.transform;

import com.avb.curd.entity.Employees;
import com.avb.curd.model.Employee;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class TransformRequest {

    public Employees parseEmployee(Employee emp){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Employees empEntity = new Employees();
        empEntity.setFirstName(emp.getFirstName());
        empEntity.setLastName(emp.getLastName());
        empEntity.setEmail(emp.getEmail());
        empEntity.setPhoneNumber(emp.getPhoneNumber());
        empEntity.setHireDate(LocalDate.parse(emp.getHireDate(), formatter));
        empEntity.setJobTitle(emp.getJobTitle());
        empEntity.setSalary(new BigDecimal(emp.getSalary()));
        empEntity.setDepartment(emp.getDepartment());
        empEntity.setGender(emp.getGender());
        empEntity.setCity(emp.getCity());
        return empEntity;
    }

    public Employees parseEmployeeEntity(Employees empEntity, Employee emp){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        empEntity.setFirstName(emp.getFirstName());
        empEntity.setLastName(emp.getLastName());
        empEntity.setEmail(emp.getEmail());
        empEntity.setPhoneNumber(emp.getPhoneNumber());
        empEntity.setHireDate(LocalDate.parse(emp.getHireDate(), formatter));
        empEntity.setJobTitle(emp.getJobTitle());
        empEntity.setSalary(new BigDecimal(emp.getSalary()));
        empEntity.setDepartment(emp.getDepartment());
        empEntity.setGender(emp.getGender());
        empEntity.setCity(emp.getCity());
        return empEntity;
    }

}
