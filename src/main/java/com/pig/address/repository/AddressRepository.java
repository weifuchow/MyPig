package com.pig.address.repository;

import com.pig.address.model.*;
import com.pig.users.model.Users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>, JpaSpecificationExecutor<Address>{

	@Query(value="select u from Address u where u.addressUserId = ?1 and u.status = 1")
	public List<Address> getAddressByUserId(Integer addressUserId);
	
}
