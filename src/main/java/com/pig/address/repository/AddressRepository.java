package com.pig.address.repository;

import com.pig.address.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>, JpaSpecificationExecutor<Address>{

}
