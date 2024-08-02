package com.avb.curd.repo;

import com.avb.curd.entity.EmployeeDetails;
import com.avb.curd.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<EmployeeDetails,Integer> {
}
