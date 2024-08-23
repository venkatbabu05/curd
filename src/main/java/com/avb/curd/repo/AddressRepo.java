package com.avb.curd.repo;

import com.avb.curd.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address, Integer> {
}

