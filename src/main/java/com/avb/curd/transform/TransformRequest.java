package com.avb.curd.transform;

import com.avb.curd.entity.Employees;
import com.avb.curd.model.Address;
import com.avb.curd.model.Employee;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TransformRequest {

    public Employees parseCreateEmployee(Employee emp) {
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
        empEntity.setCreateDate(new Date());
        empEntity.setUpdateDate(new Date());

        if (emp.getAddress() != null) {
            List<com.avb.curd.entity.Address> addressList = getAddresses(emp.getAddress());
            empEntity.setAddress(addressList);
        }
        return empEntity;
    }

    private List<com.avb.curd.entity.Address> getAddresses(List<Address> addresses) {
        List<com.avb.curd.entity.Address> addressList = new ArrayList<>();
        for (Address address : addresses) {
            com.avb.curd.entity.Address addressEntity = new com.avb.curd.entity.Address();
            addressEntity.setAddressType(address.getAddressType());
            addressEntity.setAddressOne(address.getAddressOne());
            addressEntity.setAddressTwo(address.getAddressTwo());
            addressEntity.setAddressThree(address.getAddressThree());
            addressEntity.setCity(address.getCity());
            addressEntity.setState(address.getState());
            addressEntity.setCountry(address.getCountry());
            addressEntity.setPinCode(address.getPinCode());
            addressList.add(addressEntity);
        }
        return addressList;
    }

    public Employees parseUpdateEmployee(Employees empEntity, Employee emp) {
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
        empEntity.setUpdateDate(new Date());

        if (empEntity.getAddress() != null) {
            List<com.avb.curd.entity.Address> addressList = updateAddresses(empEntity.getAddress());
            empEntity.setAddress(addressList);
        }
        return empEntity;
    }

    private List<com.avb.curd.entity.Address> updateAddresses(List<com.avb.curd.entity.Address> addresses) {
        List<com.avb.curd.entity.Address> addressList = new ArrayList<>();
        for (com.avb.curd.entity.Address address : addresses) {
            com.avb.curd.entity.Address addressEntity = new com.avb.curd.entity.Address();
            addressEntity.setAddressType(address.getAddressType());
            addressEntity.setAddressOne(address.getAddressOne());
            addressEntity.setAddressTwo(address.getAddressTwo());
            addressEntity.setAddressThree(address.getAddressThree());
            addressEntity.setCity(address.getCity());
            addressEntity.setState(address.getState());
            addressEntity.setCountry(address.getCountry());
            addressEntity.setPinCode(address.getPinCode());
            addressList.add(addressEntity);
        }
        return addressList;
    }

}
