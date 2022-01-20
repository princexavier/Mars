package com.bms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.entities.Bms;

@Repository
public interface BmsRepo extends JpaRepository<Bms, Long>{

}
