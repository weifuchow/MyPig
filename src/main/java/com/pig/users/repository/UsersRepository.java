package com.pig.users.repository;

import com.pig.users.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>, JpaSpecificationExecutor<Users>{

}
