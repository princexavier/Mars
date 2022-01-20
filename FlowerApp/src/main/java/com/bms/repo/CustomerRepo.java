package com.bms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.entities.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
