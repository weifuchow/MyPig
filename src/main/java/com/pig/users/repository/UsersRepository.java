package com.pig.users.repository;

import com.pig.users.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>, JpaSpecificationExecutor<Users>{

	@Query(value="select u from Users u where u.phone = ?1 and u.password = ?2")
	public Users login(String phone,String password);
	
}
