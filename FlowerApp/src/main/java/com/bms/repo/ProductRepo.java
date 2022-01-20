package com.bms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
