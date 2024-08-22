package com.avb.curd.service;

import com.avb.curd.entity.Employees;
import com.avb.curd.entity.User;
import com.avb.curd.model.Employee;
import com.avb.curd.transform.TransformRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    TransformRequest transformRequest;

    @Autowired
    private com.avb.curd.dao.EmployeeDao employeeDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employees processEmployeeDate(Employee emp) {
        Employees entity = transformRequest.parseEmployee(emp);
        return employeeDao.saveEmployeeData(entity);
    }

    public Optional<Employees> getEmployeeById(int empId) {
        return employeeDao.getEmployeeById(empId);
    }

    public Employees updateEmployee(int empId, Employee emp) {
        Optional<Employees> existingData = employeeDao.getEmployeeById(empId);
        if (existingData.isPresent()) {
            Employees newData = transformRequest.parseEmployeeEntity(existingData.get(), emp);
            return employeeDao.saveEmployeeData(newData);
        }
        return null;
    }

    public Employees updateEmployeeByField(int empId, Map<String, Object> emp) {
        Optional<Employees> existingData = employeeDao.getEmployeeById(empId);
        if (existingData.isPresent()) {
            emp.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Employees.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingData.get(), value);
            });
            return employeeDao.saveEmployeeData(existingData.get());
        }
        return null;
    }

    public String addUser(User userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        employeeDao.saveUser(userInfo);
        return "user added to system ";
    }
}
