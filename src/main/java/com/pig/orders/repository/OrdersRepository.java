package com.pig.orders.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pig.orders.model.Orders;


@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer>, JpaSpecificationExecutor<Orders>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update Orders t set t.status = ?1 where t.id = ?2 ")
	public int setStatus(Integer status,Integer id);	
	
}
