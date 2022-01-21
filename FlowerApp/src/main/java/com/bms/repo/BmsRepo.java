package com.bms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bms.entities.Bms;


@Repository
public interface BmsRepo extends JpaRepository<Bms, Long>{
 
	@Query(value = "select concat( fname,\" \",lname) as CustomerName,pname,quantity,unit_price,customer_amt,balance_amt,date_created,total_amt from bms b" + 
			" left join customers c" + 
			" on b.customer_id =c.id" + 
			" left join products p" + 
			" on p.id=b.product_id where b.date_created = ?1",nativeQuery = true)
	public List<Object> findAllByFilter(String date);
}
