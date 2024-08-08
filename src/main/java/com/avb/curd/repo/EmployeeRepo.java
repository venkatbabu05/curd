package com.avb.curd.repo;

import com.avb.curd.entity.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employees,Integer> {

}
